package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringCalculatorTest {
    private StringCalculator stringCalculator = new StringCalculator();

    @DisplayName("계산기 객체 생성을 성공한다.")
    @Test
    void create() {
        stringCalculator = new StringCalculator();
        assertThat(stringCalculator).isNotNull();
    }

    @DisplayName("입력값이 null일 경우 예외 발생을 성공한다.")
    @Test
    void inputValue_IsNull() {
        final String input = null;
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> { stringCalculator.calculate(input); }
        );
    }

    @DisplayName("입력값이 공백일 경우 예외 발생을 성공한다.")
    @Test
    void inputValue_IsBlank() {
        final String input = " ";
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> { stringCalculator.calculate(input); }
        );
    }

    @DisplayName("입력값을 문자열 배열로 반환하는데 성공한다.")
    @Test
    void toStringArray() {
        // given
        final String input = "2 + 3 * 4 / 2";
        final String[] expect = input.split(" ");

        // when
        final String[] actual = stringCalculator.toStringArray(input);

        // then
        assertThat(actual).containsExactly(expect);
    }

    @DisplayName("숫자 형식 체크를 성공한다.")
    @Test
    void isNumber() {
        // given
        final String input = "2";

        // when
        final boolean actual = stringCalculator.isNumber(input);

        // then
        assertThat(actual).isTrue();
    }

    @DisplayName("사칙연산자 체크를 성공한다.")
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void isOperator(String operator) {
        // when
        final boolean actual = stringCalculator.isOperator(operator);

        // then
        assertThat(actual).isTrue();
    }

    @DisplayName("덧셈을 성공한다.")
    @Test
    void plus() {
        // given
        final String input = "2 + 3";
        final int expect = 5;

        // when
        final int actual = stringCalculator.calculate(input);

        // then
        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("뺄셈을 성공한다.")
    @Test
    void minus() {
        // given
        final String input = "2 - 3";
        final int expect = -1;

        // when
        final int actual = stringCalculator.calculate(input);

        // then
        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("곱셈을 성공한다.")
    @Test
    void multiple() {
        // given
        final String input = "2 * 3";
        final int expect = 6;

        // when
        final int actual = stringCalculator.calculate(input);

        // then
        assertThat(actual).isEqualTo(expect);
    }
}