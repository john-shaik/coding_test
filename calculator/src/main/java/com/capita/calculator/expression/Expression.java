package com.capita.calculator.expression;

import java.util.Stack;

import com.capita.calculator.expression.tokenizer.NumberToken;
import com.capita.calculator.expression.tokenizer.OperatorToken;
import com.capita.calculator.expression.tokenizer.Token;

public class Expression {

	private String expression;

	public Expression(final String expression) {
		if (expression == null || expression.trim().length() == 0) {
            throw new IllegalArgumentException("Expression can not be Null or Empty");
        }
		this.expression = expression;
	}

	public double evaluate() {
		Token[] tokens = new PostfixExpressionConverter(this.expression).convert(); 
		
		final Stack<Double> output = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			Token t = tokens[i];
			if (t.getType() == NumberToken.TOKEN_NUMBER) {
				output.push(((NumberToken) t).getValue());
			} else if (t.getType() == OperatorToken.TOKEN_OPERATOR) {
				OperatorToken op = (OperatorToken) t;
				if (output.size() < op.getOperator().getNumOperands()) {
					throw new IllegalArgumentException(
							"Invalid number of operands available for '" + op.getOperator().getSymbol() + "' operator");
				}
				if (op.getOperator().getNumOperands() == 2) {
					double rightArg = output.pop();
					double leftArg = output.pop();
					output.push(op.getOperator().apply(leftArg, rightArg));
				}
			}
		}
		
		if (output.size() > 1) {
			throw new IllegalArgumentException("Invalid number of items on the output queue.");
		}
		
		return output.pop();
	}
}
