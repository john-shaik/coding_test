package com.capita.calculator.expression.tokenizer;

public abstract class Token {

    protected final int type;

    Token(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

}
