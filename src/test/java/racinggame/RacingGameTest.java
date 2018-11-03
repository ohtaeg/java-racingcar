package racinggame;

import org.junit.Test;
import racinggame.rule.RandomNumberRacingGameRule;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hspark on 02/11/2018.
 */
public class RacingGameTest {
	@Test
	public void test_레이싱게임_생성() {
		RacingGame racingGame = new RacingGame(5, 5, new RandomNumberRacingGameRule());

		assertThat(racingGame.getCarDtoList().size()).isEqualTo(5);
		assertThat(racingGame.hasNextGame()).isTrue();
	}

	@Test
	public void test_자동차_이동_확인() {
		RacingGame racingGame = new RacingGame(5, 5, (car) -> true);

		racingGame.move();

		List<CarDTO> cars = racingGame.getCarDtoList();
		for (CarDTO car : cars) {
			assertThat(car.getPosition()).isEqualTo(1);
		}
	}

	@Test
	public void test_자동차_미이동_확인() {
		RacingGame racingGame = new RacingGame(5, 5, (car) -> false);

		racingGame.move();

		List<CarDTO> cars = racingGame.getCarDtoList();
		for (CarDTO car : cars) {
			assertThat(car.getPosition()).isEqualTo(0);
		}
	}
}