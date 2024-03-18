package com.yaronxiong.seftest;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;

public class Test1 {

    public static void main(String[] args) throws IOException, IllegalAccessException, InterruptedException {
        demo6();
    }

    private static void demo6() throws IOException, InterruptedException {
        for (int i = 0; i < 1000000000; i++) {
            ByteBuffer.allocateDirect(10_000);
            Thread.sleep(1);
        }
    }

    private static void demo5() throws IOException, InterruptedException {
        for (int i = 0; i < 1000000000; i++) {
            FileInputStream fileInputStream = new FileInputStream(Paths.get("C:\\Users\\yaoyuanxiong\\Desktop\\", "Redis设计与实现.pdf").toFile());
            fileInputStream.read();
            fileInputStream.close();
            Thread.sleep(1);
        }
    }

    private static void demo4() throws IOException, InterruptedException {
        for (int i = 0; i < 1000000000; i++) {
            //final Deflater deflater = new Deflater(9, true);
            final Inflater inflater = new Inflater(true);
            // ....
            // if not call end() after using inflater, it will OOM
            // inflater.end();
            Thread.sleep(1);
        }
    }

    private static void demo3() throws IOException {
        for (int i = 0; i < 1000000000; i++) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(10000);
            GZIPOutputStream gzipOutputstream = new GZIPOutputStream(byteArrayOutputStream);
            gzipOutputstream.write("Hello World".getBytes());
            gzipOutputstream.finish();

            GZIPInputStream gzipInputStream = new GZIPInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            IOUtils.copy(gzipInputStream, new ByteArrayOutputStream());
        }
    }

    private static void demo1() throws IOException {
        for (int i = 0; i < 1000000000; i++) {
            int[] arr = new int[100000];
        }
    }

    private static void demo1_1() throws IOException {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < 1000000000; i++) {
            int[] arr = new int[100000];
            list.add(arr);
        }
    }

    private static void demo2() throws IOException {
        for (int i = 0; i < 1000000000; i++) {
            ByteArrayOutputStream out1 = new ByteArrayOutputStream(1000000);
            ByteArrayInputStream inputStream = new ByteArrayInputStream("我真是个大帅逼".getBytes());
            IOUtils.copy(inputStream, out1);
        }
    }

    private static final Logger logger = LoggerFactory.getLogger(Test1.class);

    private static byte[] decompress(byte[] contentBytes) {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            IOUtils.copy(new GZIPInputStream(new ByteArrayInputStream(contentBytes)), out);
            return out.toByteArray();
        } catch (IOException e) {
            logger.error("", e);
        }
        return new byte[0];
    }


}
