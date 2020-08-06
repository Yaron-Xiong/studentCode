package com.accompnay.work.J1.work1;

import java.util.List;

public class Method {
    private String name;
    private List<String> params;

    public Method(String name, List<String> params) {
        this.name = name;
        this.params = params;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "Method{" +
                "name='" + name + '\'' +
                ", params=" + params +
                '}';
    }
}
