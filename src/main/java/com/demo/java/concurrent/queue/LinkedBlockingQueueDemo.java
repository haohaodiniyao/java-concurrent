package com.demo.java.concurrent.queue;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * 链表结构双向阻塞队列
 * http://ifeve.com/java-blocking-queue/#more-8396
 * @author yaokai
 *
 */
public class LinkedBlockingQueueDemo {

	public static void main(String[] args) throws Exception {
		LinkedBlockingDeque<Integer> deque = new LinkedBlockingDeque<>(10);
		System.out.println(deque.pollFirst(10, TimeUnit.SECONDS));
		//生产
//		new ScheduledThreadPoolExecutor(10).scheduleAtFixedRate(new Runnable(){
//
//			@Override
//			public void run() {
//				Integer index = ThreadLocalRandom.current().nextInt(10000);
//				System.out.println("生产"+index);
//				deque.add(index);
//			}
//			
//		}, 1, 5, TimeUnit.SECONDS);
		
		
//		for(int i=0;i<10;i++){
//			Integer index = ThreadLocalRandom.current().nextInt(10000);
//			System.out.println("生产"+index);
//			deque.add(index);
//		}
		
		//消费
//		new ScheduledThreadPoolExecutor(10).scheduleAtFixedRate(new Runnable(){
//
//			@Override
//			public void run() {
//				try {
//					System.out.println("消费 "+deque.poll());
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//			
//		}, 1, 1, TimeUnit.SECONDS);
	}

}
