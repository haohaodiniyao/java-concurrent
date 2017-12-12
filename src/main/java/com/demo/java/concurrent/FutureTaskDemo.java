package com.demo.java.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FutureTaskDemo {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		FutureTask<String> ft = new FutureTask<String>(new Callable<String>(){

			@Override
			public String call() throws Exception {
				String msg = "Hello World";
				try{
					System.out.println("start process task...");
					TimeUnit.SECONDS.sleep(5);
//					int a = 1/0;
					System.out.println(msg);	
				}catch(Exception e){
					e.printStackTrace();
					throw e;
				}
				return msg;
			}
			
		});
		executor.submit(ft);
		//定时取消任务
		new ScheduledThreadPoolExecutor(10).schedule(new Runnable(){

			@Override
			public void run() {
				System.out.println("start cancel...");
				ft.cancel(true);
			}
			
		}, 3, TimeUnit.SECONDS);
		
		//此任务是否正常完成取消
		new ScheduledThreadPoolExecutor(10).scheduleWithFixedDelay(new Runnable(){

			@Override
			public void run() {
				String cancelledMsg = ft.isCancelled() ? "任务未完成被取消" : "任务正常完成";
				String doneMsg = ft.isDone() ? "任务未完成" : "任务完成";
				System.out.println("cancelledMsg:"+cancelledMsg+",doneMsg:"+doneMsg);
			}
			
		}, 1, 1, TimeUnit.SECONDS);
	}

}
