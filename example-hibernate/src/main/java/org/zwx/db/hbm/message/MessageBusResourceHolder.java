package org.zwx.db.hbm.message;

import org.springframework.transaction.support.ResourceHolderSupport;

import java.util.ArrayList;
import java.util.List;

public class MessageBusResourceHolder extends ResourceHolderSupport {
    private List<Object> pedingMessage = new ArrayList<>();

    public boolean addMessage(Object message) {
        return pedingMessage.add(message);
    }

    public List<Object> getPedingMessage() {
        return pedingMessage;
    }


}
