package com.capita.calculator.expression.tokenizer;

public final class NumberToken extends Token {
    
	public static final short TOKEN_NUMBER = 1;
	
	private final double value;

    public NumberToken(double value) {
        super(TOKEN_NUMBER);
        this.value = value;
    }

    NumberToken(final char[] expression, final int offset, final int len) {
        this(Double.parseDouble(String.valueOf(expression, offset, len)));
    }

    public double getValue() {
        return value;
    }
    
}
