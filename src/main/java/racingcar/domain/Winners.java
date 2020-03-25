package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Winners {
    public static Cars findWinner(final List<Car> cars) {
        return new Cars(filterWinner(rank(cars)));
    }

    private static PriorityQueue<Car> rank(final List<Car> cars) {
        PriorityQueue<Car> ranks = new PriorityQueue<>(Collections.reverseOrder());
        for (Car car : cars) {
            ranks.offer(car);
        }
        return ranks;
    }

    private static List<Car> filterWinner(final PriorityQueue<Car> rankedCars) {
        List<Car> winners = new ArrayList<>();
        Car firstWinner = rankedCars.poll();
        winners.add(firstWinner);

        List<Car> otherWinners = findOtherWinners(firstWinner, rankedCars);
        winners.addAll(otherWinners);
        return winners;
    }

    private static List<Car> findOtherWinners(final Car firstWinner, final PriorityQueue<Car> rankedCars) {
        List<Car> otherWinners = new ArrayList<>();
        Car otherWinner;
        while (!rankedCars.isEmpty()) {
            otherWinner = rankedCars.poll();
            if (firstWinner.match(otherWinner)) {
                otherWinners.add(otherWinner);
            }
        }
        return otherWinners;
    }
}
