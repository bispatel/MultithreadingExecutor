package com.thread.executors.returnValues;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.thread.common.CallableTaskB;
import com.thread.common.LoopTaskA;
import com.thread.common.NamedThreadFactory;
import com.thread.common.TaskResult;

public class ReturningValuesUsingExecutorSecondWay {

	public static void main(String[] args) {
		String currentThread = Thread.currentThread().getName();
		System.out.println("[" + currentThread + "] Main Thread starts here...");
		ExecutorService execService = Executors.newCachedThreadPool(new NamedThreadFactory());
		
		CompletionService<TaskResult<String, Integer>> tasks = new ExecutorCompletionService<>(execService);
		tasks.submit(new CallableTaskB(2, 3, 2000));
		tasks.submit(new CallableTaskB(12, 23, 1000));
		tasks.submit(new CallableTaskB(4, 7, 500));
		tasks.submit(new LoopTaskA(), new TaskResult<String, Integer>("LoopTaskA", 999));
		
		execService.shutdown();
		 for(int i=0;i<4;i++) {
			 try {
				System.out.println(tasks.take().get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }

		System.out.println("[" + currentThread + "] Main Thread Ends here...");
	}
}
