package com.capita.calculator.expression.tokenizer;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capita.calculator.expression.operator.AdditionOperator;
import com.capita.calculator.expression.operator.MultiplicationOperator;

public class TokenizerTest {

	@Test
	public void testTokenizer() {
		Tokenizer tokenizer = new Tokenizer("4+4");
		assertTrue(tokenizer.hasNext());
		Token numberToken1 = tokenizer.nextToken();
		assertTrue(numberToken1 instanceof NumberToken);
		
		assertTrue(tokenizer.hasNext());
		Token operatorToken = tokenizer.nextToken();
		assertTrue(operatorToken instanceof OperatorToken);
		assertTrue(((OperatorToken)operatorToken).getOperator() instanceof AdditionOperator);
		
		assertTrue(tokenizer.hasNext());
		Token numberToken2 = tokenizer.nextToken();
		assertTrue(numberToken2 instanceof NumberToken);
		
		assertFalse(tokenizer.hasNext());		
	}
	
	@Test
	public void testTokenizerWithParenthesis() {
		Tokenizer tokenizer = new Tokenizer("4+(4*4)");
		assertTrue(tokenizer.hasNext());
		Token numberToken1 = tokenizer.nextToken();
		assertTrue(numberToken1 instanceof NumberToken);
		
		assertTrue(tokenizer.hasNext());
		Token operatorToken = tokenizer.nextToken();
		assertTrue(operatorToken instanceof OperatorToken);
		assertTrue(((OperatorToken)operatorToken).getOperator() instanceof AdditionOperator);
		
		assertTrue(tokenizer.hasNext());
		Token openParantheses = tokenizer.nextToken();
		assertTrue(openParantheses instanceof OpenParenthesesToken);
		
		assertTrue(tokenizer.hasNext());
		Token numberToken2 = tokenizer.nextToken();
		assertTrue(numberToken2 instanceof NumberToken);
		
		assertTrue(tokenizer.hasNext());
		Token operatorToken2 = tokenizer.nextToken();
		assertTrue(operatorToken2 instanceof OperatorToken);
		assertTrue(((OperatorToken)operatorToken2).getOperator() instanceof MultiplicationOperator);
		
		assertTrue(tokenizer.hasNext());
		Token numberToken3 = tokenizer.nextToken();
		assertTrue(numberToken3 instanceof NumberToken);
		
		assertTrue(tokenizer.hasNext());
		Token closeParantheses = tokenizer.nextToken();
		assertTrue(closeParantheses instanceof CloseParenthesesToken);
	}

}
