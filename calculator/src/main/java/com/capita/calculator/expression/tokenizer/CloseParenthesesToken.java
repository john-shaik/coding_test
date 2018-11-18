package com.capita.calculator.expression.tokenizer;

public class CloseParenthesesToken extends Token {
	
    public static final short TOKEN_PARENTHESES_CLOSE = 4;

    CloseParenthesesToken() {
        super(TOKEN_PARENTHESES_CLOSE);
    }
}
