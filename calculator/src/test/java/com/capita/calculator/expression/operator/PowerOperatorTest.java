package com.capita.calculator.expression.operator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capita.calculator.expression.operator.PowerOperator;

public class PowerOperatorTest {

	@Test
	public void testApply() {
		PowerOperator operator = new PowerOperator();
		double value = operator.apply(5, 2);
		assertEquals(25, value, 0);
	}

}
