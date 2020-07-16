package com.accompnay.work;

import java.util.List;
import java.util.Map;

public class AddFun implements Fun<Number> {

    @Override
    public Object execute(List<Number> params) {
        double result = 0D;
        for (Number param : params) {
            result += param.doubleValue();
        }
        return result;
    }
}
