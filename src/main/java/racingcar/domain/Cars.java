package racingcar.domain;

import racingcar.policy.MovingPolicy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class Cars {
    private static final String WIN_MESSAGE = "가 최종 우승했습니다.";
    private static final String WINNER_JOIN_EXPRESSION = ", ";

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

    public String award() {
        String award = cars.stream()
                           .map(Car::getName)
                           .map(CarName::toString)
                           .collect(Collectors.joining(WINNER_JOIN_EXPRESSION))
        ;
        return award + WIN_MESSAGE;
    }
}
