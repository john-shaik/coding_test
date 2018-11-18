package com.capita.calculator.expression.operator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capita.calculator.expression.operator.AdditionOperator;

public class AdditionOperatorTest {

	@Test
	public void testApply() {
		AdditionOperator operator = new AdditionOperator();
		Double value = operator.apply(4, 2);
		assertEquals(6, value, 0);
	}

}
