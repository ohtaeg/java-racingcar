package racingcar.domain;

import racingcar.policy.MovingPolicy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public final class Cars {
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public void move(MovingPolicy movingPolicy) {
        for (Car car : cars) {
            car.move(movingPolicy);
        }
    }

    public List<Car> toList() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> findWinners() {
        return filterWinner(rank(cars));
    }

    private PriorityQueue<Car> rank(final List<Car> cars) {
        PriorityQueue<Car> ranks = new PriorityQueue<>(Collections.reverseOrder());
        for (Car car : cars) {
            ranks.offer(car);
        }
        return ranks;
    }

    private List<Car> filterWinner(final PriorityQueue<Car> rankedCars) {
        List<Car> winners = new ArrayList<>();
        Car firstWinner = rankedCars.poll();
        winners.add(firstWinner);

        Car car;
        while (!rankedCars.isEmpty()) {
            car = rankedCars.poll();
            car.addOtherWinners(winners);
        }
        return winners;
    }
}
