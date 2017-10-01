package org.zwx.db.hbm.message;

import org.springframework.transaction.support.ResourceHolder;
import org.springframework.transaction.support.ResourceHolderSynchronization;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Optional;

public class MessageBusUtils
{
    public static Optional<MessageBusResourceHolder> getTransactionalResource(Object txMess) {

        if (!TransactionSynchronizationManager.isSynchronizationActive()) {
            return Optional.ofNullable(null);
        }

        MessageBusResourceHolder mrh = (MessageBusResourceHolder) TransactionSynchronizationManager.getResource(txMess);

        if (mrh != null) {
            return Optional.of(mrh);
        }

        mrh = new MessageBusResourceHolder();
        TransactionSynchronizationManager.bindResource(txMess, mrh);
        mrh.setSynchronizedWithTransaction(true);

        if (TransactionSynchronizationManager.isSynchronizationActive()) {
            TransactionSynchronizationManager.registerSynchronization(new MessageBusResourceSynchronization(mrh, txMess));
        }

        return Optional.of(mrh);
    }


    private static class MessageBusResourceSynchronization extends ResourceHolderSynchronization{
        private MessageBusResourceHolder mrh;
        private Object txMess;

        public MessageBusResourceSynchronization(MessageBusResourceHolder mrh, Object txMess) {
            super(mrh, txMess);
            this.mrh = mrh;
            this.txMess = txMess;
        }

        @Override
        protected void cleanupResource(ResourceHolder resourceHolder, Object resourceKey, boolean committed) {
            mrh.getPedingMessage().clear();

        }

        @Override
        public void afterCompletion(int status) {
            if (status == TransactionSynchronization.STATUS_COMMITTED) {
                mrh.getPedingMessage().forEach(System.out::println);
            } else {
                mrh.getPedingMessage().clear();
            }

            super.afterCompletion(status);
        }
    }


}
