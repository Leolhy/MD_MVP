package com.leo.library.struct;

/**
 * Creator: Leoying
 * Date: 2019-01-25 14:42
 */
public abstract class FunctionWithResultOnly<R> extends Function {

    public FunctionWithResultOnly(String functionName) {
        super(functionName);
    }

    protected abstract R function();
}
