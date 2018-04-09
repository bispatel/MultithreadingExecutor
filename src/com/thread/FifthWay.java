package com.thread;

public class FifthWay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Main Method starts here...");
		
		Thread t = new Thread(new Runnable(){
			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {
					System.out.println("Test:" + i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		t.start();
		System.out.println("Main Thread ends here...");
	}
}

