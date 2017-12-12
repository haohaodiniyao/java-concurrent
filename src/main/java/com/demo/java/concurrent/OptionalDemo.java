package com.demo.java.concurrent;

import java.util.Optional;

/**
 * optional
 * @author yaokai
 *
 */
public class OptionalDemo {

	public static void main(String[] args) {
		//如果存在值，isPresent将返回ture和get()返回值
		System.out.println(Optional.of("hello world").isPresent());
		System.out.println(Optional.of("hello world").get());
		//不存在值，则返回默认值
		System.out.println(Optional.empty().orElse("null"));
		Optional.empty().ifPresent(s -> System.out.println(s));
		Optional.of(99).filter(s->s>100).ifPresent(s->System.out.println(s));
	}

}
