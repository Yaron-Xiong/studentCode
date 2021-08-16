package com.accompnay.hacking;

import com.google.common.collect.Lists;
import lombok.Data;

import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NginxLogTest {

	public static void main(String[] args) throws Exception {
		NginxLogTest nginxLogTest = new NginxLogTest();
		nginxLogTest.readAll2Oject("nginx", NginxLog.getResolveFunction());
	}

	ExecutorService executorService = Executors.newFixedThreadPool(2);

	private <T extends BaseBean> void readAll2Oject(String filePath, Function<String, T> resolveFunction) throws Exception {
		URL resource = this.getClass().getClassLoader().getResource(filePath);
		Path path = Paths.get(resource.toURI());
		File[] files = path.toFile().listFiles();
		CountDownLatch countDownLatch = new CountDownLatch(files.length);
		for (File file : files) {
			executorService.submit(new NginxRunnable(file, resolveFunction, countDownLatch));
		}
		countDownLatch.await();
		executorService.shutdown();
		System.out.println("解析完毕...");
	}

	private static final String basePath = "E:\\logreuslt";


	@Data
	public static class NginxRunnable<T extends BaseBean> implements Runnable {

		private File file;
		private Function<String, T> resolveFunction;
		private CountDownLatch countDownLatch;
		ExecutorService executorService = Executors.newFixedThreadPool(1);

		public NginxRunnable(File file, Function<String, T> resolveFunction, CountDownLatch countDownLatch) {
			this.file = file;
			this.resolveFunction = resolveFunction;
			this.countDownLatch = countDownLatch;
		}

		@Override
		public void run() {
			System.out.println("正在进行" + file.getName() + "的解析工作");
			List<T> subResult = new ArrayList<>(100000);
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
				List<String> lines = new ArrayList<>(10000);
				String line;
				while ((line = reader.readLine()) != null) {
					lines.add(line);
					subResult.add(resolveFunction.apply(line));
					if (lines.size() == 10000) {
						ArrayList<String> copy = Lists.newArrayList(lines);
						lines.clear();
						parallelWrite(copy);
					}
				}
				if (!lines.isEmpty()) {
					writeLines(lines);
				}

			} catch (Exception e) {
				System.out.println(file.getName() + "出现异常...");
			} finally {
				countDownLatch.countDown();
				executorService.shutdown();
				System.out.println(file.getName()+"解析完毕...");
			}
		}

		private void parallelWrite(List<String> lines) {
			executorService.submit(() -> writeLines(lines));
		}

		private void writeLines(List<String> lines) {
			Map<String, List<T>> map = lines.parallelStream().map(s -> resolveFunction.apply(s))
					.filter(baseBean -> baseBean.getDuoduoId() != null && !baseBean.getDuoduoId().equals(" "))
					.collect(Collectors.groupingBy(BaseBean::getDuoduoId));
			try {
				write2File(map);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		private <T extends BaseBean> void write2File(Map<String, List<T>> listMap) throws Exception {
			for (String key : listMap.keySet()) {
				List<T> list = listMap.get(key);
				write2File(basePath + "/" + file.getName(), key, list);
			}
		}

		private <T extends BaseBean> void write2File(String directoryPath, String fileName, List<T> list) throws Exception {
			File directory = new File(directoryPath);
			boolean mkdirs = directory.mkdirs();
			File file = new File(directoryPath + "/" + fileName);
			boolean newFile = file.createNewFile();
			try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)))) {
				for (T t : list) {
					writer.write(t.toString());
					writer.newLine();
				}
			}
		}
	}
}
