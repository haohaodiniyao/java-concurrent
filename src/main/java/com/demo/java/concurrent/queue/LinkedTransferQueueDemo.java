package com.demo.java.concurrent.queue;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * LinkedTransferQueue
 * http://blog.csdn.net/yjian2008/article/details/16951811
 * transfer(E e) 如果存在等待获取的消费者线程，则立刻移交；否则，将元素插入对尾，并且进入阻塞状态，直到有消费者线程取走该元素
 * tryTransfer(E e) 如果存在等待获取的消费者线程，则立刻移交；否则，返回false，并且元素不加入队列，非阻塞方法
 * tryTransfer(E e, long timeout,TimeUnit unit) 如果存在等待获取的消费者线程，则立刻移交；否则将元素加入队尾，等待消费者消费，若在指定时间内元素无法被消费者线程消费，则返回false，同时被移除
 * @author yaokai
 *
 */
public class LinkedTransferQueueDemo {

	public static void main(String[] args) {
		/**
		 * 
		 */
		Set<Integer> sets = new HashSet<>();
		sets.add(100);
		sets.add(101);
		LinkedTransferQueue<Integer> queue = new LinkedTransferQueue<>(sets);
		queue.forEach(s->System.out.println(s));
		
		new ScheduledThreadPoolExecutor(10).scheduleAtFixedRate(new Runnable(){

			@Override
			public void run() {
//				    String info = queue.hasWaitingConsumer()?"有等待的消费者":"没有等待的消费者";
//					System.out.println(info + ",数量:" + queue.getWaitingConsumerCount());
				queue.forEach(s->System.out.println(s));
			}
			
		}, 2, 5, TimeUnit.SECONDS);
		
		try {
			queue.tryTransfer(102,5,TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		new ScheduledThreadPoolExecutor(10).scheduleAtFixedRate(new Runnable(){
//
//			@Override
//			public void run() {
//				try {
//					System.out.println("消费者线程启动了..."+Thread.currentThread().getName());
//					System.out.println("消费:"+queue.take());
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//			
//		}, 1, 5, TimeUnit.SECONDS);
		

		
		
//		new ScheduledThreadPoolExecutor(10).scheduleAtFixedRate(new Runnable(){
//
//			@Override
//			public void run() {
//				    Integer index = ThreadLocalRandom.current().nextInt(1000);
//					try {
//						System.out.println("生产这线程启动了..."+Thread.currentThread().getName()+"生产:"+index);
//						queue.tryTransfer(index,3,TimeUnit.SECONDS);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//			}
//			
//		}, 1, 1, TimeUnit.SECONDS);
	}

}
