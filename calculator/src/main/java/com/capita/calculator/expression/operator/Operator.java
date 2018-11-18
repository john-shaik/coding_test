package com.capita.calculator.expression.operator;

public abstract class Operator {

	public static final char[] ALLOWED_OPERATOR_CHARS = { '+', '-', '*', '/', '^' };

	protected final int numOperands;
	protected final boolean leftAssociative;
	protected final String symbol;
	protected final int precedence;

	public Operator(String symbol, int numberOfOperands, boolean leftAssociative, int precedence) {
		super();
		this.numOperands = numberOfOperands;
		this.leftAssociative = leftAssociative;
		this.symbol = symbol;
		this.precedence = precedence;
	}

	public abstract double apply(double arg1, double args2);
	
	public static boolean isAllowedOperatorChar(char ch) {
		for (char allowed : ALLOWED_OPERATOR_CHARS) {
			if (ch == allowed) {
				return true;
			}
		}
		return false;
	}

	public boolean isLeftAssociative() {
		return leftAssociative;
	}

	public int getPrecedence() {
		return precedence;
	}

	public String getSymbol() {
		return symbol;
	}

	public int getNumOperands() {
		return numOperands;
	}
}
