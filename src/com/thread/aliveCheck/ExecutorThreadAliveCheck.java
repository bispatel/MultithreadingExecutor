package com.thread.aliveCheck;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import com.thread.common.CallableTaskA;
import com.thread.common.LoopTaskC;
import com.thread.common.NamedThreadFactory;

public class ExecutorThreadAliveCheck {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] thread starts here..");
		ExecutorService exec = Executors.newCachedThreadPool(new NamedThreadFactory());
		Future<?> f1 = exec.submit(new LoopTaskC());
		Future<Integer> f2 = exec.submit(new CallableTaskA(3,4, 100));
		
		FutureTask<?> f3 =new FutureTask<Void>(new LoopTaskC(),null);
		FutureTask<Integer> f4 =new FutureTask<Integer>(new LoopTaskC(),999);
		FutureTask<Integer> f5 =new FutureTask<Integer>(new CallableTaskA(4,5,500));
		
		exec.execute(f3);
		exec.execute(f4);
		exec.execute(f5);
		
		exec.shutdown();
		
		for(int i=0;i<=5;i++)
		{
			TimeUnit.MILLISECONDS.sleep(600);
			System.out.println("["+currentThreadName+"] ITR-="+i+"--> IS LoopTaskC-1 done:"+f1.isDone());
			System.out.println("["+currentThreadName+"] ITR-="+i+"--> IS CalcTask-1 done:"+f2.isDone());
			System.out.println("["+currentThreadName+"] ITR-="+i+"--> IS LoopTaskC-2 done:"+f3.isDone());
			System.out.println("["+currentThreadName+"] ITR-="+i+"--> IS LoopTaskC-3 done;"+f4.isDone());
			System.out.println("["+currentThreadName+"] ITR-="+i+"--> IS CalcTask-2 done:"+f5.isDone());
		}
		
		System.out.println("\n$$$ ["+currentThreadName+"] Retriving results now ... $$$");
		System.out.println("["+currentThreadName+"] 'LoopTaskC-1' result="+f1.get());
		System.out.println("["+currentThreadName+"] 'CalcTask-1' result="+f2.get());
		System.out.println("["+currentThreadName+"] LoopTaskC-2 result="+f3.get());
		System.out.println("["+currentThreadName+"] LoopTaskC-3 result="+f4.get());
		System.out.println("["+currentThreadName+"]	CalcTask-2 result="+f5.get());
		 
		System.out.println("[" + currentThreadName + "] thread ended.");
	}
	
}
