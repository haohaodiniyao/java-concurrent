package com.demo.java.concurrent.threadPoolExecutor;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
/**
 * 自定义拒绝策略
 * @author yaokai
 *
 */
public class SimplePolicy implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        throw new RejectedExecutionException("任务(Task) " + r.toString() +
                " (拒绝)rejected from " +
                executor.toString());
	}

}
