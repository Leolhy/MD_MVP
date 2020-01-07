package com.leo.library.struct;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Creator: Leoying
 * Date: 2019-01-25 14:50
 */
public class FunctionsManager {

    private Map<String, Function> functionMap;

    private static FunctionsManager instance;

    private FunctionsManager() {
        functionMap = new HashMap<>();
    }


    private static FunctionsManager getInstance() {
        if (instance == null) {
            instance = new FunctionsManager();
        }
        return instance;
    }

    public FunctionsManager addFunction(Function function) {
        functionMap.put(function.functionName, function);
        return this;
    }


    public void invokeFunc(String funcName) throws FunctionException {
        if (TextUtils.isEmpty(funcName))
            return;
        Function function = functionMap.get(funcName);
        if (function != null) {
            if (function instanceof FunctionNoParamNoResult) {
                ((FunctionNoParamNoResult) function).function();
            } else
                throw new ClassCastException(function.getClass().getName() + "can not be case to" +
                        FunctionNoParamNoResult.class.getName());
        } else {
            throw new FunctionException("this function is null");
        }
    }

    public <P> void invokeFunc(String funcName, P data) throws FunctionException {
        if (TextUtils.isEmpty(funcName))
            return;
        Function function = functionMap.get(funcName);
        if (function != null) {
            if (function instanceof FunctionWithParamOnly) {
                FunctionWithParamOnly paramOnly = (FunctionWithParamOnly) function;
                paramOnly.function(data);
            } else
                throw new ClassCastException(function.getClass().getName() + "can not be case to " +
                        FunctionWithParamOnly.class.getName());
        } else {
            throw new FunctionException("this function is null");
        }
    }

    public <R> R invokeFunc(String funcName, Class<R> cls) throws FunctionException {
        if (TextUtils.isEmpty(funcName))
            return null;
        Function function = functionMap.get(funcName);
        if (function != null) {
            if (function instanceof FunctionWithResultOnly) {
                FunctionWithResultOnly withResultOnly = (FunctionWithResultOnly) function;
                if (cls == null) {
                    return (R) withResultOnly.function();
                } else {
                    return cls.cast(withResultOnly.function());
                }
            } else
                throw new ClassCastException(function.getClass().getName() + "can not be case to" +
                        FunctionWithResultOnly.class.getName());
        } else {
            throw new FunctionException("this function is null");
        }
    }

    public <R, P> R invokeFunc(String funcName, P data, Class<R> cls) throws FunctionException {
        if (TextUtils.isEmpty(funcName))
            return null;
        Function function = functionMap.get(funcName);
        if (function != null) {
            if (function instanceof FunctionWithParamAndResult) {
                FunctionWithParamAndResult paramAndResult = (FunctionWithParamAndResult) function;
                if (cls == null) {
                    return (R) paramAndResult.function(data);
                } else {
                    return cls.cast(paramAndResult.function(data));
                }
            } else
                throw new ClassCastException(function.getClass().getName() + "can not be case to" +
                        FunctionWithParamAndResult.class.getName());
        } else {
            throw new FunctionException("this function is null");
        }
    }
}
