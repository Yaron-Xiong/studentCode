package com.accompnay.work;

import java.util.*;

public class ExpressionBuilder {

    private Map<String, Fun> funMap = new HashMap<>();

    //"f1(x, f2(x, f3(y,z)))"
    public Expression buildExpression(String s) {
        List<int[]> indexList = new ArrayList<>();
        Stack<Integer> lastIndexStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lastIndexStack.push(i);
            } else if (s.charAt(i) == ')') {
                Integer lastIndex = lastIndexStack.pop();
                //todo 添加方法的记录信息
                String method = findMethod(s, lastIndex);
                indexList.add(new int[]{lastIndex, i + 1});
            }
        }

        Stack<String> methodStack = new Stack<>();
        Map<String, List<String>> method2Params = new HashMap<>();
        for (int i = 0; i < indexList.size(); i++) {
            String substring = s.substring(indexList.get(i)[0] + 1, indexList.get(i)[1] - 1);

            if (substring.contains("(")) {
                String substring1 = s.substring(indexList.get(i - 1)[0], indexList.get(i - 1)[1]);
                String peek = methodStack.peek();
                substring = substring.replace(peek + substring1, "#" + peek.trim());
                //System.out.println("内部方法为" + peek+substring1);
            }
            String[] split = substring.split(",");
            List<String> paramsList = new ArrayList<>();
            for (String params : split) {
                params = params.trim();
                paramsList.add(params);
            }


            String methodName = findMethod(s, indexList.get(i)[0]);
            methodStack.push(methodName);
            System.out.print(paramsList);
            System.out.println("\t" + methodName);
        }
        return null;
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
