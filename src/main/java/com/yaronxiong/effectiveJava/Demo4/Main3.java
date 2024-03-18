package com.yaronxiong.effectiveJava.Demo4;

public class Main3 {
    public static void main(String[] args) throws InterruptedException {
        Main3 main = new Main3();
        String s = "210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321" +
                ".210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321" +
                ".210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321" +
                ".210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321" +
                ".210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321" +
                ".210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321" +
                ".210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321.210.76.56.183.1321";
        Long s1 = System.currentTimeMillis();
        String sum = main.defangIPaddr(s);
        Thread.sleep(1000);
        Long se1 = System.currentTimeMillis();

        Long s2 = System.currentTimeMillis();
        String sum2 =main.defangIPaddr2(s);
        Thread.sleep(1000);
        Long se2 = System.currentTimeMillis();

        System.out.println("第一次"+((Long)se1-s1));
        System.out.println("第二次"+((Long)se2-s2));
    }
    public String defangIPaddr(String address) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < address.length(); i++) {
            char c = address.charAt(i);
            if (c=='.'){
                buffer.append("[.]");
            }else {
                buffer.append(c);
            }
        }
        return new String(buffer);
    }

    public String defangIPaddr2(String address) {
        return address.replace(".","[.]");
    }
}
