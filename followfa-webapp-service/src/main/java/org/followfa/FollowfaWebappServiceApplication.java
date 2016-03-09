package org.followfa;

import org.flywaydb.core.Flyway;
import org.followfa.cancellable.WaitForOperationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class FollowfaWebappServiceApplication {
	private static final int QUEUE_CAPACITY = 100;
	public static final int CORE_POOL_SIZE = 10;
	public static final int MAXIMUM_POOL_SIZE = 100;
	public static final long KEEP_ALIVE_TIME = 0L;

	public static void main(String[] args) {
		SpringApplication.run(FollowfaWebappServiceApplication.class, args);
	}

	@Bean
	public ExecutorService executor() {
		ThreadPoolExecutor executorService = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.MILLISECONDS,
				new LinkedBlockingDeque<>(QUEUE_CAPACITY), new ThreadPoolExecutor.CallerRunsPolicy());
		return executorService;
	}

	@Bean
	public Flyway flyway() {
		return new Flyway();
	}

	@Bean
	public WaitForOperationService waitForOperationService() {
		return new WaitForOperationService(executor());
	}
}
