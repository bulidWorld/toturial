package org.zwx.tomcat;

import org.junit.runner.RunWith;

public class Acceptor implements Runnable {

    private EndPoint endPoint;

    private BaseStack<Request> stack;


    @Override
    public void run() {

        if (endPoint.accept()) {
            endPoint.processSocket(endPoint.getSocket())
        }


    }
}
