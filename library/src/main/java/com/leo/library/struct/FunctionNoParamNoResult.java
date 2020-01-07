package com.leo.library.struct;

/**
 * Creator: Leoying
 * Date: 2019-01-25 14:42
 */
public abstract class FunctionNoParamNoResult extends Function {

    public FunctionNoParamNoResult(String functionName) {
        super(functionName);
    }

    protected abstract void function();
}
