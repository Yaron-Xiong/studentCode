package com.yaronxiong.effectiveJava.Demo4;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Accompany
 * Date:2019/12/26
 */
public class Main7 {
    public static void main(String[] args) {
        ConcurrentHashMap map1 = new ConcurrentHashMap();
        map1.put("name","张三");
        map1.put("age",18);
        ConcurrentHashMap.KeySetView set = map1.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            iterator.remove();
            System.out.println(next);
            map1.put("bir","2019");
        }
        System.out.println(map1);
        /*HashMap hashMap = new HashMap();
        hashMap.put("不只Java-1", 1);
        hashMap.put("不只Java-2", 2);
        hashMap.put("不只Java-3", 3);

        Set set = hashMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            hashMap.put("下次循环会抛异常", 4);
            System.out.println("此时 hashMap 长度为" + hashMap.size());
        }*/
    }
}
