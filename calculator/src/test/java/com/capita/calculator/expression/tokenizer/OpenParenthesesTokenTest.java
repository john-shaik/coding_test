package com.capita.calculator.expression.tokenizer;

import static org.junit.Assert.*;

import org.junit.Test;

public class OpenParenthesesTokenTest {

	@Test
	public void testGetType() {
		OpenParenthesesToken token = new OpenParenthesesToken();
		assertEquals(OpenParenthesesToken.TOKEN_PARENTHESES_OPEN, token.getType());
	}

}
