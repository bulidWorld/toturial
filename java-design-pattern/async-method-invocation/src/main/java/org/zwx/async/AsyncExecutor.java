package org.zwx.async;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public interface AsyncExecutor {

    <T> AsyncResult<T> startProcess(Callable<T> task, AsyncCallback asyncCallback);

    <T> AsyncResult<T> startProcess(Callable<T> task);

    <T> T endProcess(AsyncResult<T> asyncResult) throws InterruptedException, ExecutionException;
}
