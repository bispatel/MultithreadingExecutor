package com.thread;

public class ThirdWay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Main Method starts here...");
	    new ThirdTask();
		new ThirdTask();
		System.out.println("Main Thread ends here...");
	}
}

class ThirdTask implements Runnable {
	private static int count = 0;
	private int id;

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("<" + id + ">Test:" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public ThirdTask() {
		this.id = ++count;
		new Thread(this).start();
	}

}