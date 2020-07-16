package com.accompnay.customizedThread.art;

import java.io.*;
import java.util.Scanner;

/**
 * @author Accompany
 * Date:2020/1/18
 * 管道输入/管道输出
 * 作用：同一个JVM下，两个线程可以进行数据传递
 * 注意事项：
 * 1.不能在同一个线程中开启 PipedInputStream和PipedOutputStream 否则会出现死锁现象
 * 2.PipedOutputStream需要connect到PipedInputStream否则如果直接传输数据会抛异常
 *
 * 原理：
 * 管道输入和管道输出会使用同一个内存区域
 * 管道输出会不断的往一个默认大小为1024K的数组（InputBuffer)写数据
 * 管道输入会不断的读取数组中的数据
 *
 * Buffer会被维护成一个扇形，读写的区域做到了分隔，互不影响
 *
 * 读写规则：
 * 当InputBuffer满了，管道输出不能写数据
 * 当InputBuffer空了，管道输入不能读数据
 * 当InputBuffer非满，管道输出可以写数据&&管道输入可以读数据
 */
public class Piped {
    public static void main(String[] args) throws IOException {
        PipedReader in = new PipedReader();
        PipedWriter out = new PipedWriter();
        try {
            out.connect(in);
            Thread t1 = new Thread(new ReadData(in));
            t1.start();
            int receive ;
            while ((receive = System.in.read())!=-1){
                out.write(receive);
            }
        }finally {
            out.close();
        }
    }

    static class ReadData implements Runnable{
        private final PipedReader pipedReader;
        ReadData(PipedReader pipedReader){
            this.pipedReader = pipedReader;
        }
        @Override
        public void run() {
            int receive ;
            try {
                while ((receive = pipedReader.read())!=-1){
                    System.out.print((char) receive);
                }
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                try {
                    pipedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
