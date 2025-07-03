package com.bytescraft.thread;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @author Vicky Thakor
 * @since 2025-07-03
 */
public class ControlledExecution {

    private final Logger LOGGER = Logger.getLogger(ControlledExecution.class.getName());

    public void sleep(int seconds){
        try {
            LOGGER.info("sleep for " + seconds + " seconds");
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void sleepAndLog(int seconds){
        try {
            for (int i = 0; i < seconds; i++) {
                LOGGER.info("start > sleepAndLog: " + i);
                TimeUnit.SECONDS.sleep(i);
                LOGGER.info("finish > sleepAndLog: " + i);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
