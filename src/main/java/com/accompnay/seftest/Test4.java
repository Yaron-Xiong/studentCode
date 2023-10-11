package com.accompnay.seftest;


import java.io.IOException;
import java.net.URI;

public class Test4 {
    public static void main(String[] args) throws IOException, InterruptedException {
        String str = "http:///asdas";
        try {
            URI uri = URI.create(str);
            String scheme = uri.getScheme();
            String host = uri.getHost();
            if (scheme == null) {
                throw new RuntimeException("错误的url url协议部分不能为空 请补充 http:// 或http://");
            }
            if (!scheme.equals("http") && !scheme.equals("https")) {
                throw new RuntimeException("错误的url url协议仅支持 [http|https]");
            }
            if (host == null) {
                throw new RuntimeException("错误的url host不能为空");
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("错误的url,存在非法的url字符");
        }
    }

}
