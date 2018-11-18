package com.capita.calculator.expression;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capita.calculator.expression.operator.AdditionOperator;
import com.capita.calculator.expression.tokenizer.NumberToken;
import com.capita.calculator.expression.tokenizer.OperatorToken;
import com.capita.calculator.expression.tokenizer.Token;

public class PostfixExpressionConverterTest {

	@Test
	public void testConvert() {
		PostfixExpressionConverter converter = new PostfixExpressionConverter("4+8");
		Token[] tokens = converter.convert();
		
		assertEquals(3, tokens.length);
		assertTrue(tokens[0] instanceof NumberToken);
		assertEquals(4.0, ((NumberToken) tokens[0]).getValue(), 0);
		
		assertTrue(tokens[1] instanceof NumberToken);
		assertEquals(8.0, ((NumberToken) tokens[1]).getValue(), 0);
		
		assertTrue(tokens[2] instanceof OperatorToken);
		assertTrue(((OperatorToken) tokens[2]).getOperator() instanceof AdditionOperator);
				
	}

}
