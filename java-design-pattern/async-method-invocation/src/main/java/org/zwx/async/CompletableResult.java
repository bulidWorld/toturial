package org.zwx.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableResult<T> implements AsyncResult {

    private static final Logger LOG = LoggerFactory.getLogger(CompletableResult.class);

    private T result;

    private Optional<AsyncCallback> sc;

    private Exception exception;

    private int state = RUNNING;

    private static final int RUNNING = 1;

    private static final int FAILED = 2;

    private static final int COMPLETED = 3;

    private Object lock = new Object();
    @Override
    public boolean isComplete() {
        return state > FAILED;
    }

    public CompletableResult(AsyncCallback callback) {
        sc = Optional.ofNullable(callback);
    }

    @Override
    public Object getValue() throws ExecutionException {
        if (state == COMPLETED) {
            return result;
        } else if (state == FAILED) {
            throw new ExecutionException(exception);
        } else {
            throw new IllegalStateException("task not completed");
        }
    }

    public void setValue(T result) {
        this.state = COMPLETED;
        this.result = result;
        sc.ifPresent(callback -> callback.onComplete(result, Optional.empty()));
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    @Override
    public void await() throws InterruptedException {
        synchronized (lock) {
            if (!isComplete()) {
                lock.wait();
            }
        }
    }

    public void setException(Exception exp) {
        this.state = FAILED;
        this.exception = exp;
        sc.ifPresent(callback -> callback.onComplete(null, Optional.of(exp)));
        synchronized (lock) {
            lock.notifyAll();
        }
    }
}
