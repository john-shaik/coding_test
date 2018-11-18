package com.capita.calculator.expression.operator;

public class MultiplicationOperator extends Operator {

	public static final int PRECEDENCE_MULTIPLICATION = 1000;
	
	public MultiplicationOperator() {
		super("*", 2, true, PRECEDENCE_MULTIPLICATION);
	}

	@Override
	public double apply(double arg1, double arg2) {
		return arg1 * arg2;
	}

}
