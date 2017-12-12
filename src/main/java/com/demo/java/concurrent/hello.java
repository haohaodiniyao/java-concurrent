package com.demo.java.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class hello extends FutureTask<String> {
	public hello(Callable<String> callable) {
		super(callable);
	} 

	@Override
	protected void done() {
		// TODO Auto-generated method stub
		super.done();
	}

}
