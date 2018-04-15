package com.serviceinfotech;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

@Configuration
public class TestApplicationConfiguration {
    @Bean
    public ThreadPoolExecutor testTaskExecutor()
    {
        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,
                5,
                120,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(30));
        return threadPool;
    }

}
