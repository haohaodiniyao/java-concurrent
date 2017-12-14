package com.demo.java.concurrent.queue;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * 同步阻塞队列
 * http://ifeve.com/java-synchronousqueue/
 * @author yaokai
 *
 */
public class SynchronousQueueDemo {

	public static void main(String[] args) {
		final SynchronousQueue<String> queue = new SynchronousQueue<String>();
		new ScheduledThreadPoolExecutor(10).scheduleWithFixedDelay(new Runnable(){
  
			@Override
			public void run() {
				try {
					int index = ThreadLocalRandom.current().nextInt(0, 100);
					queue.put("hello"+index);
					System.out.println("put1 hello"+index);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}, 1, 1, TimeUnit.SECONDS);
		
		
		new ScheduledThreadPoolExecutor(10).scheduleWithFixedDelay(new Runnable(){

			@Override
			public void run() {
				try {
					int index = ThreadLocalRandom.current().nextInt(0, 100);
					queue.put("hello"+index);
					System.out.println("put2 hello"+index);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}, 1, 2, TimeUnit.SECONDS);
		
		
		new ScheduledThreadPoolExecutor(10).scheduleWithFixedDelay(new Runnable(){

			@Override
			public void run() {
				try {
					System.out.println("take1 "+queue.take());;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}, 1, 3, TimeUnit.SECONDS);
		
	}

}
