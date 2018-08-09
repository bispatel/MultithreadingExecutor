package com.thread.executors.returnValues;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.thread.common.CallableTaskA;
import com.thread.common.LoopTaskA;
import com.thread.common.NamedThreadFactory;

public class ReturningValuesUsingExecutorFirstWay {

	public static void main(String[] args) {
		String currentThread =Thread.currentThread().getName();
		System.out.println("["+currentThread+"] Main Thread starts here...");
		ExecutorService execService = Executors.newCachedThreadPool(new NamedThreadFactory());

		Future<Integer> result1 = execService.submit(new CallableTaskA(2, 3, 2000));
		Future<Integer> result2 = execService.submit(new CallableTaskA(12, 23, 1000));
		Future<Integer> result3 = execService.submit(new CallableTaskA(4, 7, 500));
		
		Future<?> result4= execService.submit(new LoopTaskA());
		Future<Double> result5= execService.submit(new LoopTaskA(),999.888);
		execService.shutdown();
		try {
			System.out.println("Result-1=="+result1.get());
			System.out.println("Result-2=="+result2.get());
			System.out.println("Result-3=="+result3.get());
			System.out.println("Result-4=="+result4.get());
			System.out.println("Result-5=="+result5.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		System.out.println("["+currentThread+"] Main Thread Ends here...");
	}
}
