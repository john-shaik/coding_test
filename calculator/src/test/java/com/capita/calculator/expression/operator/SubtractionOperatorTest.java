package com.capita.calculator.expression.operator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capita.calculator.expression.operator.SubtractionOperator;

public class SubtractionOperatorTest {

	@Test
	public void testApply() {
		SubtractionOperator operator = new SubtractionOperator();
		double value = operator.apply(5, 2);
		assertEquals(3, value, 0);
	}

}
