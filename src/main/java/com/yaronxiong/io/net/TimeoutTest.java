package com.yaronxiong.io.net;

import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class TimeoutTest {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        for (int i = 0; i < 5; i++) {
            URI uri = new URI("http://127.0.0.1:8099/event");
            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setConnectTimeout(500);
            connection.setReadTimeout(50000);
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            String s = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
            inputStream.close();
            System.out.println(s);
            TimeUnit.SECONDS.sleep(30);
        }

    }
}
