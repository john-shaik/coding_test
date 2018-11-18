package com.capita.calculator.expression.tokenizer;

import com.capita.calculator.expression.operator.Operator;

public class OperatorToken extends Token{
	
    public static final short TOKEN_OPERATOR = 2;
	
    private final Operator operator;

    public OperatorToken(Operator op) {
        super(TOKEN_OPERATOR);
        if (op == null) {
            throw new IllegalArgumentException("Operator is unknown for token.");
        }
        this.operator = op;
    }

    public Operator getOperator() {
        return operator;
    }
}
