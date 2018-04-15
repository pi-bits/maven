package com.serviceinfotech;

import java.util.concurrent.Callable;

public class ChildWorker implements Runnable{

    private String parentReferenceId;

    public ChildWorker(String parentReferenceId) {
        this.parentReferenceId = parentReferenceId;
    }

    @Override
    public void run() {
        System.out.println("Child Task Finished for parent : " +parentReferenceId );
    }
}
