package org.zwx.async;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class App {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadAsyncExecutor executor = new ThreadAsyncExecutor();

        AsyncCallback<String> asyncCallback = (str, op) -> System.out.println(str);

        AsyncResult<String> result = executor.startProcess(()->{
            LOG.info("start process");
            TimeUnit.SECONDS.sleep(5);
            return "天青色等烟雨，而我在等你";
        },asyncCallback);

        result.await();

    }
}
