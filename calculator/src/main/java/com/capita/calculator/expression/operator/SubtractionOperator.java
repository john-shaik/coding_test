package com.capita.calculator.expression.operator;

public class SubtractionOperator extends Operator {

	public static final int PRECEDENCE_SUBTRACTION = AdditionOperator.PRECEDENCE_ADDITION;
	
	public SubtractionOperator() {
		super("-", 2, true, PRECEDENCE_SUBTRACTION);
	}

	@Override
	public double apply(double arg1, double arg2) {
		return arg1 - arg2;
	}

}
