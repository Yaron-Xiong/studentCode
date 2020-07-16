package com.accompnay.work;

import java.util.List;
import java.util.Map;

public interface Fun<T> {
    Object execute(List<T> params);
}
