package com.demo.java.concurrent.queue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * BlockingDeque双端阻塞队列
 * LinkedBlockingDeque
 * take-删除-阻塞-返回元素
 * remove-删除-非阻塞-返回boolean结果
 * put-加入-阻塞-队列没有容量会阻塞等待控件可用
 * push-加入-非阻塞
 * poll-删除-非阻塞
 * peek-检索
 * offer-加入-
 * add-加入
 * @author yaokai
 *
 */
public class BlockingDequeDemo {

	public static void main(String[] args) throws Exception {
		BlockingDeque<Integer> deque = new LinkedBlockingDeque<>(5);
//		for(int i=0;i<5;i++){
//			System.out.println("加入"+i+",result:"+deque.add(i));	
//		}
//		deque.forEach(s->System.out.println(s));
		
//		for(int i=0;i<5;i++){
//			deque.addFirst(i);
//		}
//		deque.forEach(s->System.out.println(s));
		
//		for(int i=0;i<5;i++){
//		deque.addLast(i);
//	    }
//	    deque.forEach(s->System.out.println(s));
//	    System.out.println(deque.contains(1));
//	    System.out.println(deque.element());
//		Iterator<Integer> ite = deque.iterator();
//		while(ite.hasNext()){
//			System.out.println(ite.next());
//		}
//		new ScheduledThreadPoolExecutor(10).scheduleAtFixedRate(new Runnable(){
//
//			@Override
//			public void run() {
//				deque.remove(1);
//			}
//			
//		}, 5, 1, TimeUnit.SECONDS);
//		for(int i=0;i<6;i++){
//			deque.put(i);
//	    }
		
//		System.out.println(deque.poll(5,TimeUnit.SECONDS));
//		deque.add(1);
//		deque.add(2);
//		deque.add(3);
//		deque.add(1);
//		System.out.println(deque.removeLastOccurrence(1));
//		deque.take();
//		deque.forEach(s->System.out.println(s));
		for(int i=0;i<5;i++){
		deque.put(i);
    }
		deque.forEach(s->System.out.println(s));
	}

}
