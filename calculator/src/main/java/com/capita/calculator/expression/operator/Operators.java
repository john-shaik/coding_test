package com.capita.calculator.expression.operator;

import java.util.HashMap;
import java.util.Map;

public final class Operators {
    
    private static final Map<String, Operator> operatorsMap = new HashMap<>(); 

    static {
    	operatorsMap.put("+", new AdditionOperator());
    	operatorsMap.put("-", new SubtractionOperator());
    	operatorsMap.put("*", new MultiplicationOperator());
    	operatorsMap.put("/", new DivisionOperator());
    	operatorsMap.put("^", new PowerOperator());
    }

    public static Operator getBuiltinOperator(final String symbol) {
    	return operatorsMap.get(symbol);
    }

}
