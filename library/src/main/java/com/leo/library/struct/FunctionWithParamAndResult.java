package com.leo.library.struct;

/**
 * Creator: Leoying
 * Date: 2019-01-25 14:42
 */
public abstract class FunctionWithParamAndResult<P, R> extends Function {

    public FunctionWithParamAndResult(String functionName) {
        super(functionName);
    }

    protected abstract R function(P p);
}
