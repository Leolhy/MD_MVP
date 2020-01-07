package com.leo.library.struct;

/**
 * Creator: Leoying
 * Date: 2019-01-25 14:42
 */
public abstract class FunctionWithParamOnly<P> extends Function {

    public FunctionWithParamOnly(String functionName) {
        super(functionName);
    }

    protected abstract void function(P p);
}
