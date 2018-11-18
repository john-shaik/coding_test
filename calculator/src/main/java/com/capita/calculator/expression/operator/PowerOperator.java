package com.capita.calculator.expression.operator;

public class PowerOperator extends Operator {

	public static final int PRECEDENCE_POWER = 10000;
	
	public PowerOperator() {
		super("^", 2, false, PRECEDENCE_POWER);
	}

	@Override
	public double apply(double arg1, double arg2) {
		return Math.pow(arg1, arg2);
	}

}
