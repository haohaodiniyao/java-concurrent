package com.demo.java.concurrent.threadPoolExecutor;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * newCachedThreadPool
 * 核心线程数为0
 * 最大线程数无线
 * 使用同步阻塞队列
 * 因为只要大于核心线程数，任务就会先存入队列，队列满了，再新建线程处理任务，直至最大线程数
 * 此缓冲只要有任务到来就大于核心线程数，尝试存入队列，(因为是同步阻塞队列，必须有消费者线程存在，否则无法将任务存入队列)，显然加入队列失败,则创建新线程
 * SynchronousQueue的一个使用场景是在线程池里。
 * Executors.newCachedThreadPool()就使用了SynchronousQueue，
 * 这个线程池根据需要（新任务到来时）创建新的线程，如果有空闲线程则会重复使用，线程空闲了60秒后会被回收。
 * @author yaokai
 *
 */
public class NewCachedThreadPoolDemo {

	public static void main(String[] args) {
		//自定义cachedThreadPool
		ThreadPoolExecutor executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
		//监控cachedThreadPool
		new ScheduledThreadPoolExecutor(10).scheduleAtFixedRate(new Runnable(){

			@Override
			public void run() {
				System.out.println("poolSize:"+executor.getPoolSize()+",activeCount:"+executor.getActiveCount()+",largestPoolSize:"+executor.getLargestPoolSize());
			}
			
		}, 1, 1, TimeUnit.SECONDS);
		
		new ScheduledThreadPoolExecutor(10).scheduleAtFixedRate(new Runnable(){

			@Override
			public void run() {
				executor.submit(new Runnable(){

					@Override
					public void run() {
						try {
							TimeUnit.SECONDS.sleep(1500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("task:"+ThreadLocalRandom.current().nextInt(0,100));
					}
					
				});
			}
			
		}, 1, 1, TimeUnit.SECONDS);
	}

}
