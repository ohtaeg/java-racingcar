package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.*;
import racingcar.policy.fake.SuccessMovingPolicy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(new CarName("pobi")));
        carList.add(new Car(new CarName("crong")));
        carList.add(new Car(new CarName("honux")));
        cars = new Cars(carList);
    }

    @DisplayName("자동차들이 총 1번 이동을 성공한다.")
    @Test
    void move() {
        // when
        cars.move(new SuccessMovingPolicy());

        // then
        for (Car car : cars.toList()) {
            assertThat(car.currentDistance().toInt()).isEqualTo(1);
        }
    }

    @DisplayName("우승자를 구할 수 있다.")
    @Test
    void findWinners() {
        // given
        Car pobi = new Car(new CarName("pobi"), new Distance(3));
        Car ohtaeg = new Car(new CarName("ohtaeg"), new Distance(2));
        Car nana = new Car(new CarName("nana"), new Distance(3));
        Cars cars = new Cars(Arrays.asList(pobi, ohtaeg, nana));

        // when
        List<Car> winners = cars.findWinners();

        assertThat(winners).hasSize(2);
        assertThat(winners).contains(pobi, nana);
    }
}