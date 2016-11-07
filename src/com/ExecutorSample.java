package com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ExecutorSample {
	public static void main(String args[]){
		ExecutorService singleExecutor = Executors.newSingleThreadExecutor();
		singleExecutor.submit(() -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Thread Name :"+threadName);
		});
		ExecutorService fixedExecutor = Executors.newFixedThreadPool(5);
		fixedThreadExecutor(fixedExecutor);
		IntStream.range(1, 10).forEach(i -> fixedThreadExecutor(fixedExecutor));
	}

	private static void fixedThreadExecutor(ExecutorService fixedExecutor) {
		fixedExecutor.submit(() -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Thread Name :"+threadName);
		});
	}
}
