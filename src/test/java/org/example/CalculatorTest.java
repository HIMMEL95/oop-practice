package org.example;

//- 요구사항
//- 간단한 사칙연산을 할 수 있다.
//- 양수로만 계산할 수 있다
//- 나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.
//- MVC패턴 (Model-View-Controller) 기반으로 구현한다.

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CalculatorTest {

    // 1 + 2 (2개의 피연사자와 1개의 연산자) --> Calculator에게 위임
    //   3    <-----

    // 1. 각 연산자 별로 나눠서 Test Code 작성하는 법
//    @DisplayName("덧셈 연산을 수행한다.")
//    @Test
//    void additionTest() {
//        int result = Calculator.calculate(1, "+", 2);
//
//        assertThat(result).isEqualTo(3);
//    }
//
//    @DisplayName("뺄셈 연산을 수행한다.")
//    @Test
//    void subtractionTest() {
//        int result = Calculator.calculate(1, "-", 2);
//
//        assertThat(result).isEqualTo(-1);
//    }

//    2. 하나의 Test Code로 각 연산 실행하기
    @DisplayName("덧셈 연산을 수행한다.")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void calculateTest(int operand1, String operator, int operand2, int result) {
//        int result = Calculator.calculate(1, "+", 2);
        int calculateResult = Calculator.calculate(operand1, operator, operand2);

//        assertThat(result).isEqualTo(3);
        assertThat(calculateResult).isEqualTo(result);
    }

    private static Stream<Arguments> formulaAndResult() {
        return Stream.of(
                arguments(1, "+", 2, 3),
                arguments(1, "-", 2, -1),
                arguments(4, "*", 2, 8),
                arguments(4, "/", 2, 2)
        );
    }
}
