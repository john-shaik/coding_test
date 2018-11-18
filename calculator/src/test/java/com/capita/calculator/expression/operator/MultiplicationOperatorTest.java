package com.capita.calculator.expression.operator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capita.calculator.expression.operator.MultiplicationOperator;

public class MultiplicationOperatorTest {

	@Test
	public void testApply() {
		MultiplicationOperator operator = new MultiplicationOperator();
		double value = operator.apply(4, 2);
		assertEquals(8, value, 0);
	}

}
