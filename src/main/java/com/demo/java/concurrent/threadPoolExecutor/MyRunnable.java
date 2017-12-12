package com.demo.java.concurrent.threadPoolExecutor;

import java.util.concurrent.TimeUnit;

public class MyRunnable implements Runnable {
	private int index;
	public MyRunnable(int index){
		this.index = index;
	}
	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
//			e.printStackTrace();
			System.out.println("中断"+index+","+e.getMessage());
		}
		System.out.println("任务:"+index);
	}

}
