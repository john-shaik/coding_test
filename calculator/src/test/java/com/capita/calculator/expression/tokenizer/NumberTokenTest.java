package com.capita.calculator.expression.tokenizer;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberTokenTest {

	@Test
	public void testNumberToken() {
		NumberToken numberToken = new NumberToken(4.0);
		assertEquals(4.0, numberToken.getValue(), 0);
	}
	
	@Test
	public void testGetType() {
		NumberToken token = new NumberToken(4.0);
		assertEquals(NumberToken.TOKEN_NUMBER, token.getType());
	}
}
