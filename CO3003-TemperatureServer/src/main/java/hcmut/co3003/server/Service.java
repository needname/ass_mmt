/*
 * Copyright (c) 2018 by Duong Thai Minh.
 * All rights reserved.
 */

package hcmut.co3003.server;

import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.logging.Logger;

public abstract class Service<V> implements Callable<V>, Runnable {
    protected Logger logger = Global.LoggerDefault;
    protected Socket client;

    public Service(Socket client) {
        this.client = client;
    }

    public void setLogger(String loggerName) {
        this.logger = Logger.getLogger(loggerName);
    }

    /**
     * Invoked when the Task is executed, the call method must be overridden and
     * implemented by subclasses. The call method actually performs the
     * background thread logic. Only the updateProgress, updateMessage, updateValue and
     * updateTitle methods of Task may be called from code within this method.
     * Any other interaction with the Task from the background thread will result
     * in runtime exceptions.
     *
     * @return The result of the background work, if any.
     * @throws Exception an unhandled exception which occurred during the
     *                   background operation
     */
    @Override
    public abstract V call() throws Exception;

    @Override
    public void run() {
        try {
            this.call();
        } catch (Exception e) {

        }
    }
}