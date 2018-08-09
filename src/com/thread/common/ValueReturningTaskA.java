package com.thread.common;

import java.util.concurrent.TimeUnit;

public class ValueReturningTaskA implements Runnable {
	
	private int a;
	private int b;
	private long sleepTime;
	private int sum;
	private static int count=0;
	private int instanceNum;
	private String taskId;
	
	private volatile boolean isdone=false;
	public ValueReturningTaskA (int a, int b, long sleepTime){
		this.a=a;
		this.b=b;
		this.sleepTime=sleepTime;
		this.instanceNum = ++count;
		this.taskId = "ValueReturningTaskA-"+ instanceNum;
	}

	@Override
	public void run() {
		String currentThread = Thread.currentThread().getName();
		System.out.println("#####[" + currentThread + "] <" + taskId+ "> STARTING...");
		System.out.println("[" + currentThread + "] <" + taskId+ "> Sleeping For..."+sleepTime+ " milliseconds..");
		 
			try {
				TimeUnit.MILLISECONDS.sleep(sleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sum = a+b;			
		System.out.println("#####[" + currentThread + "] <" + taskId+ "> Ended...");
		
		isdone=true;
		synchronized (this) {			
				System.out.println(" ["+currentThread+"] <"+taskId+">==is Notifying ");
				this.notifyAll();			
		}
	}
	
	public int getSum(){
		if(! isdone) {
			synchronized (this) {
				try {
					System.out.println("The calling thread ["+Thread.currentThread().getName()+"]  is waiting for result from "+taskId);
					this.wait();
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("["+Thread.currentThread().getName()+"] Woken up for "+taskId);
		}
		return sum;
	}

}
