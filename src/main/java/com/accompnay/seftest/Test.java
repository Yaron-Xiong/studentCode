package com.accompnay.seftest;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Test {

	private static class CheckThread implements Runnable {
		private static final int TAKE_LOG_WAIT_TIME = 2;
		private DelayQueue<OrderWrapper> orderList = new DelayQueue<>();
		@Override
		public void run() {
			while (true) {
				try {
					OrderWrapper wrapper = orderList.poll(TAKE_LOG_WAIT_TIME, TimeUnit.SECONDS);
					if (wrapper == null) {
						continue;
					}
					if(!wrapper.canRedo()) {
						orderList.add(wrapper);
						continue;
					}
					if(wrapper.failTimesLimit()) {
						// 达到最大次数不再自动查询了，可以采用手动方式查询
						continue;
					}
					System.out.println("正在执行redoCount:"+wrapper.redoCount);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		public void offer(OrderWrapper orderWrapper){
			orderList.offer(orderWrapper);
		}
	}
	public static void main(String[] args) throws Exception {
		CheckThread checkThread = new CheckThread();
		new Thread(()->{
			checkThread.run();
		}).start();
		checkThread.offer(new OrderWrapper(4));
		checkThread.offer(new OrderWrapper(3));
		checkThread.offer(new OrderWrapper(5));
		checkThread.offer(new OrderWrapper(2));
	}

	public static class OrderWrapper implements Delayed{
		// 默认重试时间间隔，120s * n
		private static final long DEFAULT_REDO_INTERVAL = 2 * 1000L;
		private static final long MAX_REDO_TIMES = 38;

		private long nextRedoTime;
		private int redoCount;

		public OrderWrapper(int redoCount) {
			this.redoCount = redoCount;
			this.nextRedoTime = redoCount*DEFAULT_REDO_INTERVAL + System.currentTimeMillis();
		}

		public boolean canRedo() {
			return nextRedoTime <= System.currentTimeMillis();
		}

		public boolean failTimesLimit() {
			return redoCount > MAX_REDO_TIMES;
		}

		public void afterFail() {
			this.redoCount ++;
			nextRedoTime = System.currentTimeMillis() + redoCount * DEFAULT_REDO_INTERVAL;
		}


		@Override
		public long getDelay(TimeUnit unit) {
			return nextRedoTime - System.currentTimeMillis();
		}

		@Override
		public int compareTo(Delayed o) {
			OrderWrapper orderWrapper = (OrderWrapper) o;
			return Long.compare(this.nextRedoTime, orderWrapper.nextRedoTime);
		}
	}
}
