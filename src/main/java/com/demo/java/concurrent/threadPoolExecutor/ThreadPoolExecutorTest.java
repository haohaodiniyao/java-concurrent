package com.demo.java.concurrent.threadPoolExecutor;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * 工作线程数小于核心线程数则创建线程处理请求，否则请求放入队列中，当队列已满时，才创建新线程单线程总数要小于等于最大线程数
 * @author yaokai
 *
 */
public class ThreadPoolExecutorTest {

	public static void main(String[] args) {
		SimpleThreadPoolExecutor executor = new SimpleThreadPoolExecutor(2,5,1,TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
		//设置核心线程空闲自动回收
		executor.allowCoreThreadTimeOut(true);
		//启动所有核心线程
		System.out.println("启动所有核心线程:"+executor.prestartAllCoreThreads());
		//启动核心线程
		System.out.println("启动核心线程(全部启动返回false):"+executor.prestartCoreThread());
		//定时监控线程池
		new ScheduledThreadPoolExecutor(10).scheduleWithFixedDelay(new Runnable(){

			@Override
			public void run() {
				System.out.println("poolSize:"+executor.getPoolSize()
				+",isShutDown:"+executor.isShutdown()
				+",isTerminated:"+executor.isTerminated()
				+",isTerminating:"+executor.isTerminating()
//				+",corePoolSize:"+executor.getCorePoolSize()
//				+",maximumPoolSize:"+executor.getMaximumPoolSize()
//				+",blockingQueue:"+executor.getQueue().size()
//				+",正在执行任务的线程的大概数量activeCount:"+executor.getActiveCount()
//				+",完成执行的任务的大致总数completedTaskCount:"+executor.getCompletedTaskCount()
//				+",在池中同时进行的最大线程数largesPoolSize:"+executor.getLargestPoolSize()
//				+",计划执行的任务的大概总数taskCount:"+executor.getTaskCount()
				+"线程池暂停:,"+executor.isPaused());				
			}
			
		}, 1, 1, TimeUnit.SECONDS);
		
		
		//定时监控线程池
//		new ScheduledThreadPoolExecutor(10).scheduleWithFixedDelay(new Runnable(){
//
//			@Override
//			public void run() {
//				System.out.println("线程池参数:"+executor.toString());				
//			}
//			
//		}, 1, 1, TimeUnit.SECONDS);
		
		//定时暂停线程池
		new ScheduledThreadPoolExecutor(10).schedule(new Runnable(){

			@Override
			public void run() {
				System.out.println("开始暂停线程池...6s后恢复...");
				executor.pause();
			}
			
		}, 6, TimeUnit.SECONDS);
		
		
		//定时恢复线程池
		new ScheduledThreadPoolExecutor(10).schedule(new Runnable(){

			@Override
			public void run() {
				System.out.println("开始恢复线程池...");
				executor.resume();
			}
			
		}, 20, TimeUnit.SECONDS);
		
		//定时修改线程池corePoolSize和maximumPoolSize
		new ScheduledThreadPoolExecutor(10).schedule(new Runnable(){

			@Override
			public void run() {
				System.out.println("开始修改线程池corePoolSize=5,maximumPoolSize=10");	
				executor.setCorePoolSize(5);
				executor.setMaximumPoolSize(10);
			}
			
		}, 5, TimeUnit.SECONDS);
		
		
		//定时shutdownNow线程池
		new ScheduledThreadPoolExecutor(10).schedule(new Runnable(){

			@Override
			public void run() {
				System.out.println("开始shutdownNow...");
				executor.shutdownNow();
			}
			
		}, 30, TimeUnit.SECONDS);
		
		//定时提交任务
		new ScheduledThreadPoolExecutor(10).scheduleWithFixedDelay(new Runnable(){

			@Override
			public void run() {
				try{
					executor.submit(new MyRunnable(new Random().nextInt(1000)));	
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
		},1 ,1 ,TimeUnit.SECONDS);	
		
		
		
		try {
			TimeUnit.DAYS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
