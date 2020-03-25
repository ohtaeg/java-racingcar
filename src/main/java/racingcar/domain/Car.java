package racingcar.domain;

import racingcar.policy.MovingPolicy;

import java.util.Objects;

public final class Car implements Comparable<Car> {
    private final CarName name;
    private Distance distance;

    public Car(CarName name) {
        this(name, new Distance());
    }

    public Car(final CarName name, final Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public void move(final MovingPolicy movingPolicy) {
        if (movingPolicy.isPossibleMove()) {
            distance.increase();
        }
    }

    public CarName getName() {
        return name;
    }

    public Distance currentDistance() {
        return distance;
    }

    public boolean match(final Car other) {
        return distance.equals(other.distance);
    }

    @Override
    public int compareTo(final Car car) {
        return distance.compare(car.distance);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Car car = (Car) o;
        return Objects.equals(name, car.name) &&
                Objects.equals(distance, car.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }
}
