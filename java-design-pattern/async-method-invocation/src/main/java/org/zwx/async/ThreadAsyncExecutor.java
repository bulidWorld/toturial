package org.zwx.async;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class ThreadAsyncExecutor implements AsyncExecutor {
    @Override
    public <T> AsyncResult<T> startProcess(Callable<T> task, AsyncCallback asyncCallback) {
        final CompletableResult asyncResult = new CompletableResult(asyncCallback);
        new Thread(() -> {
            try {
                T val = task.call();
                asyncResult.setValue(val);
            } catch (Exception e) {
                e.printStackTrace();
                asyncResult.setException(e);
            }
        }).start();
        return asyncResult;
    }

    @Override
    public <T> AsyncResult<T> startProcess(Callable<T> task) {
        return startProcess(task, null);
    }

    @Override
    public <T> T endProcess(AsyncResult<T> asyncResult) throws InterruptedException, ExecutionException {
        if (!asyncResult.isComplete()) {
            asyncResult.await();
        }
        return asyncResult.getValue();
    }
}
