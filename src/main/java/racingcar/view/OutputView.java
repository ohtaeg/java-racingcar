package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.CarName;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static final String GAME_RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_JOIN_EXPRESSION = ", ";
    private static final String WIN_MESSAGE = "가 최종 우승했습니다.";

    public OutputView() {}

    public void view(List<Car> cars) {
        Output output;
        for (Car car : cars) {
            output = new Output();
            // TODO : 디미터법칙
            System.out.print(car.getName().toString() + " : ");
            output.mappingToBar(car.currentDistance().toInt());
            print(output.getBar());
        }
        nextLine();
    }

    public void print(String message) {
        System.out.println(message);
    }

    public void nextLine() {
        System.out.println();
    }

    public void award(final List<Car> winners) {
        String award = winners.stream()
                              .map(Car::getName)
                              .map(CarName::toString)
                              .collect(Collectors.joining(WINNER_JOIN_EXPRESSION));
        print(award + WIN_MESSAGE);
    }
}
