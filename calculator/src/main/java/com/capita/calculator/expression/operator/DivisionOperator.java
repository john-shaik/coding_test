package com.capita.calculator.expression.operator;

public class DivisionOperator extends Operator {

	public static final int PRECEDENCE_DIVISION = MultiplicationOperator.PRECEDENCE_MULTIPLICATION;
	
	public DivisionOperator() {
		super("/", 2, true, PRECEDENCE_DIVISION);
	}

	@Override
	public double apply(double arg1, double arg2) {
		if (arg2 == 0d) {
            throw new ArithmeticException("Division by zero!");
        }
        return arg1 / arg2;
	}

}
