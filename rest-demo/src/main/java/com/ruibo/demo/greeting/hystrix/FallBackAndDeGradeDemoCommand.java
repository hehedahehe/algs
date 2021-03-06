package com.ruibo.demo.greeting.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixThreadPoolKey;

public class FallBackAndDeGradeDemoCommand extends HystrixCommand<String> {

	private final int id;

	protected FallBackAndDeGradeDemoCommand(int id) {
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("RemoteServiceX"))
				.andCommandKey(HystrixCommandKey.Factory.asKey("GetValueCommand")));
		this.id = id;
	}


	@Override
	protected String run() {
		// RemoteService.getValue(id);
		throw new RuntimeException("force failure for example");
	}

	@Override
	protected String getFallback() {
		return new FallbackViaNetwork(id).execute();
	}

	private static class FallbackViaNetwork extends HystrixCommand<String> {
		private final int id;

		public FallbackViaNetwork(int id) {
			super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("RemoteServiceX"))
					.andCommandKey(HystrixCommandKey.Factory.asKey("GetValueFallbackCommand"))
					// 使用不同的线程池做隔离，防止上层线程池跑满，影响降级逻辑.
					.andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("RemoteServiceXFallback")));
			this.id = id;
		}

		@Override
		protected String run() {
//			MemCacheClient.getValue(id);
			return "";
		}

		@Override
		protected String getFallback() {
			return null;
		}
	}
}
