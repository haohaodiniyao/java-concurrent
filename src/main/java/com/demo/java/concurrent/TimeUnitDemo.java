package com.demo.java.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class TimeUnitDemo {

	public static void main(String[] args) {
		Stream.of(TimeUnit.values()).forEach(s->System.out.println(s.name()));
		
		System.out.println("分钟:"+TimeUnit.HOURS.toMinutes(2));
		
		//1
		System.out.println("天数:"+TimeUnit.DAYS.convert(36*3600, TimeUnit.SECONDS));
		
		Thread t = new Thread(new Runnable(){

			@Override
			public void run() {
				//Thread.sleep
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
			
		});
		
		try {
			//Thread.join
			TimeUnit.SECONDS.timedJoin(t, 1);
			System.out.println("timed join...");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
