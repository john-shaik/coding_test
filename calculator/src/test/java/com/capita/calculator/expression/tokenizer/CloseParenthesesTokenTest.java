package com.capita.calculator.expression.tokenizer;

import static org.junit.Assert.*;

import org.junit.Test;

public class CloseParenthesesTokenTest {

	@Test
	public void testGetType() {
		CloseParenthesesToken token = new CloseParenthesesToken();
		assertEquals(CloseParenthesesToken.TOKEN_PARENTHESES_CLOSE, token.getType());
	}

}
