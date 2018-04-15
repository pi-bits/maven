package com.serviceinfotech;

import java.util.concurrent.Callable;

public class ChildWorkerCallable implements Callable{

    private String parentReferenceId;

    public ChildWorkerCallable(String parentReferenceId) {
        this.parentReferenceId = parentReferenceId;
    }

    @Override
    public Object call() throws Exception {
        System.out.println("Child Task Finished for parent : " +parentReferenceId );
        return parentReferenceId;
    }


}
