package org.zwx.business.delegate;

public class App {
    public static void main(String[] args) {

        EjbService ejbService = new EjbService();
        JmsService jmsService = new JmsService();

        LookupService lookupService = new LookupService();
        lookupService.setEjbService(ejbService);
        lookupService.setJmsService(jmsService);

        BusinessDelegate businessDelegate = new BusinessDelegate(lookupService);
        businessDelegate.setServiceType(ServiceType.EJB);

        Client client = new Client(businessDelegate);
        client.doTask();

        businessDelegate.setServiceType(ServiceType.JMS);
        client.doTask();
    }
}
