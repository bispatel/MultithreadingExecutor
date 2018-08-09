package com.thread;

public class FourthWay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Main Method starts here...");
	    Thread t1 = new Thread(new FourthTask());
	    Thread t2 = new Thread(new FourthTask());
		t1.start();
		t2.start();
		System.out.println("Main Thread ends here...");
	}
}

class FourthTask implements Runnable {
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

	public FourthTask() {
		this.id = ++count;
	}

}