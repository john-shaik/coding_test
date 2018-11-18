package com.capita.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capita.calculator.exception.InvalidExpression;

public class CalculatorTest {

	@Test
    public void testCalculator() {
        Calculator cal = new CalculatorImpl();
        cal.setExpression("7+(6*5^2+3-4/2)");
        double value = cal.calculate();
        assertEquals(158, value, 0);
    }

    @Test(expected = InvalidExpression.class )
    public void testCalculatorForInvalidExpression() {
        Calculator cal = new CalculatorImpl();
        cal.setExpression("7+(67(56*2))");
        cal.calculate();
    }
    
    @Test(expected = InvalidExpression.class )
    public void testCalculatorForExpression3() {
        Calculator cal = new CalculatorImpl();
        cal.setExpression("8*+7");
        cal.calculate();
    }

    @Test
    public void testCalculatorForExpression4() {
        Calculator cal = new CalculatorImpl();
        cal.setExpression("(8*5/8)-(3/1)-5");
        double value = cal.calculate();
        assertEquals(-3, value, 0);
    }
    
    @Test(expected = NullPointerException.class)
    public void testCalculatorForNullExpression() {
    	Calculator cal = new CalculatorImpl();
    	cal.calculate();
    }
    
    @Test
    public void testCalculatorForExpression5() {
        Calculator cal = new CalculatorImpl();
        cal.setExpression("4*5+4*10+4*15");
        double value = cal.calculate();
        assertEquals(120, value, 0);
    }

}
