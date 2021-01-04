package com.rain.controller;

import com.irdstudio.sdk.beans.core.threadpool.ExecuteRtnInfo;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<ExecuteRtnInfo> {

    /** 自动流程动作 */
    private String bpaAction;
    /** 自动流程标识 */
    private String bpaId;
    /** 业务流水号 */
    private String bpaSerialNo;

    public MyCallable(String batchAction, String bpaId, String bpaSerialNo){
        this.bpaId = bpaId;
        this.bpaSerialNo = bpaSerialNo;
        this.bpaAction = bpaAction.toLowerCase();
    }

    @Override
    public ExecuteRtnInfo call() throws Exception {

        System.out.println("多线程！" + bpaAction + bpaId + bpaSerialNo);

        return null;
    }
}
