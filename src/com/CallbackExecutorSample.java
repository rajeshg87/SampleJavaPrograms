package com;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallbackExecutorSample {
	public static void main(String args[]) throws InterruptedException, ExecutionException{
		Callable<Double> task = () -> {
								 return Math.random();
		};
		
		ExecutorService callableExecutor = Executors.newFixedThreadPool(5);
		Future<Double> future = callableExecutor.submit(task);
		Double result = future.get();
		System.out.println(result);
	}
}
