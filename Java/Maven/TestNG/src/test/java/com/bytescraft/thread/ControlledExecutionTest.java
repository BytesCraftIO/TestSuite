package com.bytescraft.thread;


import org.testng.annotations.Test;

/**
 * @author Vicky Thakor
 * @since 2025-07-03
 */
public class ControlledExecutionTest {

    private ControlledExecution controlledExecution = new ControlledExecution();

    @Test(groups = {"FastTest"})
    public void sleep_10s(){
        controlledExecution.sleep(10);
    }

    @Test(groups = {"FastTest"})
    public void sleep_20s(){
        controlledExecution.sleep(20);
    }

    @Test(groups = {"SlowTest"})
    public void sleep_30s(){
        controlledExecution.sleep(30);
    }

    @Test
    public void sleepAndLog_5s(){
        controlledExecution.sleepAndLog(5);
    }
}
