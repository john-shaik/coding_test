package com.capita.calculator.expression.tokenizer;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capita.calculator.expression.operator.AdditionOperator;

public class OperatorTokenTest {

	@Test
	public void testOperatorToken() {
		AdditionOperator operator = new AdditionOperator();
		OperatorToken token = new OperatorToken(operator);
		assertEquals(operator, token.getOperator());
	}

	@Test
	public void testGetType() {
		AdditionOperator operator = new AdditionOperator();
		OperatorToken token = new OperatorToken(operator);
		assertEquals(OperatorToken.TOKEN_OPERATOR, token.getType());
	}
}
