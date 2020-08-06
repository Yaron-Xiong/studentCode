package com.accompnay.work.J1.work2;

import com.google.common.collect.Lists;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

public class DirectoryReadImpl implements IWordRead {
	private int poolSize;

	DirectoryReadImpl(int poolSize) {
		this.poolSize = poolSize;
	}

	DirectoryReadImpl() {
		poolSize = 5;
	}

	@Override
	public List<String> wordList(String path) throws Exception {
		//String directoryPath = this.getClass().getClassLoader().getResource(path).getFile();
		if (path == null || path.equals("")) {
			throw new IllegalAccessException("目录不存在");
		}
		File file = new File(path);
		if (!file.isDirectory()) {
			throw new IllegalAccessException("这是一个文件夹");
		}
		File[] files = file.listFiles();
		if (Objects.isNull(files) || files.length == 0) {
			return Lists.newArrayList();
		}
		WordReadPool wordReadPool = new WordReadPool(poolSize);
		List<String> result = Collections.synchronizedList(new ArrayList<>());
		CountDownLatch countDownLatch = new CountDownLatch(files.length);
		for (File txtFile : files) {
			wordReadPool.read(txtFile.getPath(), result, countDownLatch);
		}
		countDownLatch.await();
		System.out.println(String.format("使用了%s个线程", wordReadPool.poolSize()));
		wordReadPool.shutdown();
		return result;
	}
}
