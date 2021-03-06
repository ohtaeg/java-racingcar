package racingcar;

import racingcar.controller.RacingGame;
import racingcar.domain.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String carNames = inputView.inputCarNames();
        int round = inputView.inputCarCount();

        RacingGame racingGame = new RacingGame(carNames, new Round(round));

        outputView.nextLine();
        outputView.print(OutputView.GAME_RESULT_MESSAGE);
        while (!racingGame.isGameOver()) {
            racingGame.play();
            outputView.view(racingGame.getCars().toList());
        }

        List<Car> winners = racingGame.getCars()
                                      .findWinners();
        outputView.award(winners);
    }
}
