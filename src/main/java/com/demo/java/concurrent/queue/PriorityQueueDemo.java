package com.demo.java.concurrent.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
/**
 * 优先级队列
 * @author yaokai
 *
 */
public class PriorityQueueDemo {
    public static Comparator<User> userComparator = new Comparator<User>(){

		@Override
		public int compare(User u1, User u2) {
			return u2.getId().compareTo(u1.getId());
		}
    	
    };
	public static void main(String[] args) {
		//自然顺序
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(11);
		for(int i=0;i<10;i++){
			queue.add(new Random().nextInt(100));
		}
		for(int i=0;i<10;i++){
			System.out.println(queue.poll());
		}

		PriorityQueue<User> userQueue = new PriorityQueue<User>(11,userComparator);
		//生产users
		for(int i=0;i<10;i++){
			Integer index = new Random().nextInt(100);
			userQueue.add(new User(index,"user"+index));
		}
		
		for(int i=0;i<10;i++){
			System.out.println(userQueue.poll());
		}
	}

}
