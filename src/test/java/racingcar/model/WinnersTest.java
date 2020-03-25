package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @DisplayName("우승자를 구할 수 있다.")
    @Test
    void findWinners() {
        final List<Car> cars = Arrays.asList(
                new Car(new CarName("fobi"), new Distance(3))
                , new Car(new CarName("ohtaeg"), new Distance(2))
               ,  new Car(new CarName("dd"), new Distance(3))
        );

        Cars winners = Winners.findWinner(cars);

        assertThat(winners.toList()).hasSize(2);
        assertThat(winners.toList()).contains(new Car(new CarName("fobi"), new Distance(3)), new Car(new CarName("dd"), new Distance(3)));
    }
}