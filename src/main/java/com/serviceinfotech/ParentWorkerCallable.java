package com.serviceinfotech;

import org.springframework.core.task.AsyncTaskExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class ParentWorkerCallable implements Callable {


    private AsyncTaskExecutor taskExecutor;

    public ParentWorkerCallable(AsyncTaskExecutor taskExecutor) {

        this.taskExecutor = taskExecutor;
    }


    @Override
    public Object call() throws Exception {
        try {
            System.out.println("Parent Task Started :" + this.toString());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ChildWorkerCallable childWorker = new ChildWorkerCallable(this.toString());
        System.out.println("Child task started " + childWorker.toString() + " for parent " + this.toString());
        Future<?> future = taskExecutor.submit(childWorker);
        return future.get();

    }


}
