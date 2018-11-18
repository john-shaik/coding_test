package com.capita.calculator.expression.operator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capita.calculator.expression.operator.DivisionOperator;

public class DivisionOperatorTest {

	@Test
	public void testApply() {
		DivisionOperator divisionOperator = new DivisionOperator();
		double value = divisionOperator.apply(10, 2);
		assertEquals(5, value, 0);
	}
	
	@Test(expected = ArithmeticException.class)
	public void testApplyWhenDividentIsZero() {
		DivisionOperator divisionOperator = new DivisionOperator();
		divisionOperator.apply(10, 0);
	}

}
