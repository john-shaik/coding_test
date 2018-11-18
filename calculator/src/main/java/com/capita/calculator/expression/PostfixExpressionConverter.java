package com.capita.calculator.expression;

import static com.capita.calculator.expression.tokenizer.CloseParenthesesToken.TOKEN_PARENTHESES_CLOSE;
import static com.capita.calculator.expression.tokenizer.NumberToken.TOKEN_NUMBER;
import static com.capita.calculator.expression.tokenizer.OpenParenthesesToken.TOKEN_PARENTHESES_OPEN;
import static com.capita.calculator.expression.tokenizer.OperatorToken.TOKEN_OPERATOR;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.capita.calculator.expression.tokenizer.OperatorToken;
import com.capita.calculator.expression.tokenizer.Token;
import com.capita.calculator.expression.tokenizer.Tokenizer;

public class PostfixExpressionConverter {
	
	private final String expression;

	public PostfixExpressionConverter(final String expression) {
		this.expression = expression;
	}

    public Token[] convert(){
        final Stack<Token> stack = new Stack<>();
        final List<Token> output = new ArrayList<>();

        final Tokenizer tokenizer = new Tokenizer(expression);
        while (tokenizer.hasNext()) {
            Token token = tokenizer.nextToken();
            switch (token.getType()) {
            case TOKEN_NUMBER:
            	output.add(token);
                break;
            case TOKEN_OPERATOR:
                while (!stack.empty() && stack.peek().getType() == TOKEN_OPERATOR) {
                    OperatorToken o1 = (OperatorToken) token;
                    OperatorToken o2 = (OperatorToken) stack.peek();
                    if (o1.getOperator().getNumOperands() == 1 && o2.getOperator().getNumOperands() == 2) {
                        break;
                    } else if ((o1.getOperator().isLeftAssociative() && o1.getOperator().getPrecedence() <= o2.getOperator().getPrecedence())
                            || (o1.getOperator().getPrecedence() < o2.getOperator().getPrecedence())) {
                        output.add(stack.pop());
                    }else {
                        break;
                    }
                }
                stack.push(token);
                break;
            case TOKEN_PARENTHESES_OPEN:
                stack.push(token);
                break;
            case TOKEN_PARENTHESES_CLOSE:
                while (stack.peek().getType() != TOKEN_PARENTHESES_OPEN) {
                    output.add(stack.pop());
                }
                stack.pop();
                break;
            default:
                throw new IllegalArgumentException("Unknown Token type encountered. This should not happen");
            }
        }
        while (!stack.empty()) {
            Token t = stack.pop();
            if (t.getType() == TOKEN_PARENTHESES_CLOSE || t.getType() == TOKEN_PARENTHESES_OPEN) {
                throw new IllegalArgumentException("Mismatched parentheses detected. Please check the expression");
            } else {
                output.add(t);
            }
        }
        return output.toArray(new Token[output.size()]);
    }
}
