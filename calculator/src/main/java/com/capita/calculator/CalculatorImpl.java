package com.capita.calculator;

import com.capita.calculator.exception.InvalidExpression;
import com.capita.calculator.expression.Expression;

public class CalculatorImpl implements Calculator {

    private String expression;
    
    public CalculatorImpl() {
    }
    
    public CalculatorImpl(String expression) {
    	this.expression = expression;
    }

    public double calculate() {
    	if(this.expression == null) {
    		throw new NullPointerException("Expression is null. Can't calculate. ");
    	}
    	
    	double value = 0;
        
    	try {
        	Expression exp = new Expression(this.expression);
            value = exp.evaluate();
        } catch (Exception e) {
            throw new InvalidExpression(e.getMessage(), e);
        }
        return value;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
