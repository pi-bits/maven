package com.serviceinfotech;

import org.springframework.core.task.AsyncTaskExecutor;

public class ParentWorker implements Runnable {


    private AsyncTaskExecutor taskExecutor;

    public ParentWorker(AsyncTaskExecutor taskExecutor) {

        this.taskExecutor = taskExecutor;
    }


    @Override
    public void run() {
            System.out.println("Parent Task Started :" + this.toString());
            ChildWorker childWorker = new ChildWorker(this.toString());
             System.out.println("Child task started " + childWorker.toString() + " for parent " + this.toString());
            taskExecutor.execute(childWorker);

    }
}
