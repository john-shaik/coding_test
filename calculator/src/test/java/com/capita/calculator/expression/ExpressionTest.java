package com.capita.calculator.expression;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capita.calculator.expression.Expression;

public class ExpressionTest {

	@Test(expected = IllegalArgumentException.class)
	public void testExpressionWithNullAgrument() {
		new Expression(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExpressionWithEmptyAgrument() {
		new Expression("");
	}
	
	@Test
	public void testExpression() {
		Expression exp = new Expression("4+4");
		assertNotNull(exp);
	}

	@Test
	public void testEvaluate() {
		Expression exp = new Expression("4+4");
	 	double value = exp.evaluate();
	 	assertEquals(8, value, 0);
	}

}
