package org.zwx.async;

import java.util.concurrent.ExecutionException;

public interface AsyncResult<T> {

    boolean isComplete();

    T getValue() throws ExecutionException;

    void await() throws InterruptedException;
}
