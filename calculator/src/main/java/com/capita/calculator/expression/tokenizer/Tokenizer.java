package com.capita.calculator.expression.tokenizer;

import static com.capita.calculator.expression.tokenizer.NumberToken.TOKEN_NUMBER;

import com.capita.calculator.expression.operator.Operator;
import com.capita.calculator.expression.operator.Operators;

public class Tokenizer {

	private final char[] expression;

	private final int expressionLength;

	private int pos = 0;

	private Token lastToken;

	public Tokenizer(String expression) {
		this.expression = expression.trim().toCharArray();
		this.expressionLength = this.expression.length;
	}

	public boolean hasNext() {
		return this.expression.length > pos;
	}

	public Token nextToken() {
		char ch = expression[pos];
		while (Character.isWhitespace(ch)) {
			ch = expression[++pos];
		}
		if (Character.isDigit(ch)) {
			if (lastToken != null) {
				if (lastToken.getType() == TOKEN_NUMBER) {
					throw new IllegalArgumentException("Unable to parse char '" + ch + "' at [" + pos + "]");
				}
			}
			return parseNumberToken(ch);
		} else if (isOpenParentheses(ch)) {
			return parseParentheses(true);
		} else if (isCloseParentheses(ch)) {
			return parseParentheses(false);
		} else if (Operator.isAllowedOperatorChar(ch)) {
			return parseOperatorToken(ch);
		}
		throw new IllegalArgumentException("Unable to parse char '" + ch + "' at [" + pos + "]");
	}

	private Token parseParentheses(final boolean open) {
		if (open) {
			this.lastToken = new OpenParenthesesToken();
		} else {
			this.lastToken = new CloseParenthesesToken();
		}
		this.pos++;
		return lastToken;
	}

	private boolean isOpenParentheses(char ch) {
		return ch == '(';
	}

	private boolean isCloseParentheses(char ch) {
		return ch == ')';
	}

	private Token parseOperatorToken(char firstChar) {
		final int offset = this.pos;
		int len = 1;
		final StringBuilder symbol = new StringBuilder();
		Operator lastValid = null;
		symbol.append(firstChar);

		while (!isEndOfExpression(offset + len) && Operator.isAllowedOperatorChar(expression[offset + len])) {
			symbol.append(expression[offset + len++]);
		}

		while (symbol.length() > 0) {
			Operator op = this.getOperator(symbol.toString());
			if (op == null) {
				symbol.setLength(symbol.length() - 1);
			} else {
				lastValid = op;
				break;
			}
		}
		pos += symbol.length();
		lastToken = new OperatorToken(lastValid);
		return lastToken;
	}

	private Operator getOperator(String symbol) {
		Operator op = null;
		if (op == null && symbol.length() == 1) {
			op = Operators.getBuiltinOperator(symbol);
		}
		return op;
	}

	private Token parseNumberToken(final char firstChar) {
		final int offset = this.pos;
		int len = 1;
		this.pos++;
		if (isEndOfExpression(offset + len)) {
			lastToken = new NumberToken(Double.parseDouble(String.valueOf(firstChar)));
			return lastToken;
		}
		while (!isEndOfExpression(offset + len) && isNumeric(expression[offset + len])) {
			len++;
			this.pos++;
		}
		lastToken = new NumberToken(expression, offset, len);
		return lastToken;
	}

	private static boolean isNumeric(char ch) {
		return Character.isDigit(ch);
	}

	private boolean isEndOfExpression(int offset) {
		return this.expressionLength <= offset;
	}
}
