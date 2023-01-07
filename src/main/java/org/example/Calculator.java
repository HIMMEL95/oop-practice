package org.example;

import org.example.calculate.*;

import java.util.List;

public class Calculator {
    private static final List<NewArithmeticOperator> arithmeticOperators = List.of(new AdditionOperator(), new SubtractionOperator(), new DivisionOperator(), new MultiplicationOperator());
    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
//        1. 각 연사자 별로 나눠서 작성
//        if ("+".equals(operator)) {
//            return operand1 + operand2;
//        } else if("-".equals(operator)) {
//            return operand1 - operand2;
//        } else if ("*".equals(operator)) {
//            return operand1 * operand2;
//        } else if ("/".equals(operator)) {
//            return operand1 / operand2;
//        }
//        return 0;

//        2. 하나의 Test Code 로 모든 연산자 받아서 사용 (enum 사용)
//        return ArithmeticOperator.calculate(operand1, operator, operand2);

//        3. interface 방식
        return arithmeticOperators.stream()
                .filter(arithmeticOperators -> arithmeticOperators.supports(operator))
                .map(arithmeticOperators -> arithmeticOperators.calculate(operand1, operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
