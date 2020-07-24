package com.accompnay.work.J1;

import java.util.*;

public class ExpressionBuilder {

    private Map<String, Fun> funMap = new HashMap<>();

    // f1(x, f2(x, f5(p,o,u),z),f3(q,w,e,f4(r,t,y)))
    public Expression buildExpression(String s) {
        s = s.trim();
        Stack<Integer> lastIndexStack = new Stack<>();
        Queue<Method> methodQueue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lastIndexStack.push(i);
            } else if (s.charAt(i) == ')') {
                Integer lastIndex = lastIndexStack.pop();
                String methodName = findMethod(s, lastIndex);
                List<String> paramsList = findParams(s, lastIndex + 1, i);
                Method method = new Method(methodName, paramsList);
                methodQueue.add(method);
                String methodDesigin = methodName + s.substring(lastIndex, i + 1);
                s = s.replace(methodDesigin, "#" + methodName);
                i = i - (methodDesigin.length() - methodName.length() + 1);
            }
        }

        return new Expression(methodQueue, funMap);
    }

    // f1(x, f2(x, f5(p,o,u),z),f3(q,w,e,f4(r,t,y)))
    private List<String> findParams(String s, Integer startIndex, Integer endIndex) {
        String[] split = s.substring(startIndex, endIndex).split(",");
        List<String> result = new ArrayList<>();
        Collections.addAll(result, split);
        return result;
    }

    public String findMethod(String s, int index) {
        StringBuilder methodName = new StringBuilder();
        for (int i = index - 1; i >= 0; i--) {
            if (s.charAt(i) == ',') {
                break;
            }
            methodName.append(s.charAt(i));
        }
        methodName.reverse();
        return methodName.toString();
    }

    public void addFunc(String f1, Fun fun) {
        funMap.put(f1, fun);
    }
}
