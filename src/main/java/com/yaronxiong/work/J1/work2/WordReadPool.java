package com.yaronxiong.work.J1.work2;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class WordReadPool {

	private ThreadPoolExecutor executor;

	WordReadPool(int threadNum) {
		if (threadNum <= 0) {
			throw new IllegalArgumentException();
		}
		executor = new ThreadPoolExecutor(threadNum
				, threadNum
				, 0
				, TimeUnit.SECONDS, new LinkedBlockingQueue<>(threadNum * 2)
				, new WorkThreadFactory());
	}

	public void read(String filePath, List<String> list, CountDownLatch countDownLatch) {
		Runnable runnable = new WordRunnable(filePath, countDownLatch, list);
		executor.execute(runnable);
	}

	public int poolSize(){
		return executor.getPoolSize();
	}

	public void shutdown(){
		executor.shutdown();
	}

	private static class WorkThreadFactory implements ThreadFactory{

		AtomicInteger atomic = new AtomicInteger(0);

		@Override
		public Thread newThread(Runnable r) {
			return new Thread(r, "Thread_WordRead_" + atomic.getAndIncrement());
		}
	}

	private static class WordRunnable implements Runnable {
		private String filePath;
		private CountDownLatch countDownLatch;
		private List<String> countWordList;

		public WordRunnable(String filePath, CountDownLatch countDownLatch, List<String> countWordList) {
			this.filePath = filePath;
			this.countDownLatch = countDownLatch;
			this.countWordList = countWordList;
		}

		@Override
		public void run() {
			try {
				IWordRead reader = new TxtWordReadImpl();
				List<String> wordList = reader.wordList(filePath);
				countWordList.addAll(wordList);
				System.out.println(Thread.currentThread().getName() + "done");
			} catch (Exception e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			} finally {
				countDownLatch.countDown();
			}
		}
	}
}
