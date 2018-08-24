package com.thread.terminate.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.thread.common.CallableTaskB;
import com.thread.common.CallableTaskC;
import com.thread.common.FactorialTaskB;
import com.thread.common.LoopTaskA;
import com.thread.common.LoopTaskF;
import com.thread.common.NamedThreadFactory;
import com.thread.common.TaskResult;

public class TerminatingAllExecutor {

	public static void main(String[] args) throws Exception {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] thread starts here..");

		ExecutorService execService = Executors.newCachedThreadPool(new NamedThreadFactory());

		LoopTaskA t1 = new LoopTaskA();
		LoopTaskF t2 = new LoopTaskF();
		FactorialTaskB t3 = new FactorialTaskB(30, 500);
		CallableTaskC t4 = new CallableTaskC();
		CallableTaskB t5 = new CallableTaskB(2, 3, 9000);

		execService.execute(t1);
		execService.execute(t2);
		Future<Long> t3Future =execService.submit(t3); 
		Future<Long> t4Future =execService.submit(t4);
		Future<TaskResult<String,Integer>> t5Future =execService.submit(t5);
		

		TimeUnit.MILLISECONDS.sleep(1000);
		execService.shutdownNow();

		System.out.println("[" + currentThreadName + "] ALL THREADS TERMINATED = "
				+ execService.awaitTermination(500, TimeUnit.MILLISECONDS));
		
		System.out.println("["+currentThreadName+"] FactorialtaskB-1 Result:"+t3Future.get());
		System.out.println("["+currentThreadName+"] CallabletaskC-1 Result:"+t4Future.get());
		try {
		System.out.println("["+currentThreadName+"] CallableTaskB-1 Result:"+t5Future.get());
		}catch(Exception e) {
			System.out.println("[" + currentThreadName + "] CallableTaskB-1 Result=Got Execution Exception. Cause is:"+e);	
		}

		System.out.println("[" + currentThreadName + "] thread ended.");

	}
}

