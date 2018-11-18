package com.capita.calculator.exception;

public class InvalidExpression extends RuntimeException {


	/**
	 * Generated Serial Version UID
	 */
	private static final long serialVersionUID = 6921992631888127265L;

	public InvalidExpression(String errorMsg, Throwable e) {
        super(errorMsg, e);
    }
}
