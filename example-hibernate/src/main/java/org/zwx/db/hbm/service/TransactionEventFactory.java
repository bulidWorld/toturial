package org.zwx.db.hbm.service;

import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;

import java.util.function.Consumer;

public class TransactionEventFactory {

    public static <T> TransactionSynchronizationAdapter getRollBackEvent(Consumer<T> consumer) {
        return new RollBackEvent<T>(consumer);
    }


    private static class RollBackEvent<T> extends TransactionSynchronizationAdapter {

        private Consumer<T> consumer;

        private T t;

        public RollBackEvent(Consumer<T> consumer){
            this.consumer = consumer;
        }

        @Override
        public void afterCompletion(int status) {
            if (status == TransactionSynchronization.STATUS_ROLLED_BACK) {
                consumer.accept(t);
                System.out.println("hello rollback");
            }
            super.afterCompletion(status);
        }
    }


}
