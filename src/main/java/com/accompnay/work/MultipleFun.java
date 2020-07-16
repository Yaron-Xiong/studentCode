package com.accompnay.work;

import java.util.List;
import java.util.Map;

public class MultipleFun implements Fun<Number> {

    @Override
    public Object execute(List<Number> params) {
        double result = 1D;
        for (Number param : params) {
            result *= param.doubleValue();
        }
        return result;
    }
}
