package com.capita.calculator.expression.tokenizer;

public class OpenParenthesesToken extends Token {

	public static final short TOKEN_PARENTHESES_OPEN = 3;
	
    OpenParenthesesToken() {
        super(TOKEN_PARENTHESES_OPEN);
    }
}
