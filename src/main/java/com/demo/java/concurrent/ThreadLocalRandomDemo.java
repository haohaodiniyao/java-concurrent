package com.demo.java.concurrent;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.DoubleStream;

/**
 * ThreadLocalRandom
 * https://www.cnblogs.com/latteyan/p/7879078.html
 */
public class ThreadLocalRandomDemo 
{
    public static void main( String[] args )
    {
    	ThreadLocalRandom tlr = ThreadLocalRandom.current();
    	DoubleStream ds = tlr.doubles(0,100);
    	//DoublePredicate dp = s -> s < 100 && s > 0; 
    	//生成10个double随机数
    	ds.limit(10).forEach(s->System.out.println(s));
    }
}
