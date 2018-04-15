package com.serviceinfotech.service;

import com.serviceinfotech.ParentWorker;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class UpdateService {

    private AsyncTaskExecutor taskExecutor;

    public UpdateService(AsyncTaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
        ThreadPoolTaskExecutor threadPoolTaskExecutor = (ThreadPoolTaskExecutor) taskExecutor;
        threadPoolTaskExecutor.setThreadNamePrefix("UpdateService-ThreadPoolTaskExecutor-");
    }
    public void update() {
        ParentWorker parentWorker = new ParentWorker(taskExecutor);
        taskExecutor.execute(parentWorker);
    }
}
