package com.yaronxiong.work.J1.work1;

import java.util.List;

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
