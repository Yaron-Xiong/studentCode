package com.yaronxiong.io.net;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.util.StreamUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

public class TimeoutTest2 {
    private static final String HTTPS_PROTOCOL = "https";
    private static final String HTTP_PROTOCOL = "http";

    private static X509TrustManager getX509TrustManager() {
        return new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

            }

            @Override
            public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[]{};
            }
        };
    }

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException, NoSuchAlgorithmException, KeyManagementException, KeyStoreException {
        SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
            @Override
            public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                return true;
            }
        }).build();

        SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext,
                SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setConnectTimeout(500)
                .setSocketTimeout(100000)
                .setConnectionRequestTimeout(10000)
                .build();

        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(sslConnectionSocketFactory)
                //单个host最高支持400并发
                .setMaxConnPerRoute(400)
                //支持2000并发
                .setMaxConnTotal(2000)
                //定期回收空闲连接
                .evictIdleConnections(60, TimeUnit.SECONDS)
                //定期回收过期连接
                .evictExpiredConnections()
                //默认请求参数
                .setDefaultRequestConfig(defaultRequestConfig)

                .setKeepAliveStrategy(DefaultConnectionKeepAliveStrategy.INSTANCE)
                //禁用掉重试,按需开启
                .setRetryHandler(new DefaultHttpRequestRetryHandler(0, false))
                .build();

        String url = "http://aqsy-yducaccount.sdk.100bt.com/healthy/check.json";
        String url2 = "http://pe-oneserver.100bt.com/healthy/check.json";
        for (int i = 0; i < 5; i++) {
            HttpUriRequest request = new HttpGet(url2);
            HttpResponse execute = httpClient.execute(request);
            HttpEntity entity = execute.getEntity();
            InputStream content = entity.getContent();
            String s = StreamUtils.copyToString(content, StandardCharsets.UTF_8);
            content.close();
            System.out.println(s);
            TimeUnit.SECONDS.sleep(45);
        }
    }
}
