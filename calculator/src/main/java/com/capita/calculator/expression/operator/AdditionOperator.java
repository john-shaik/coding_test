package com.capita.calculator.expression.operator;

public class AdditionOperator extends Operator {

	public static final int PRECEDENCE_ADDITION = 500;
	
	public AdditionOperator() {
		super("+", 2, true, PRECEDENCE_ADDITION);
	}

	@Override
	public double apply(double arg1, double arg2) {
		return arg1 + arg2;
	}

}
