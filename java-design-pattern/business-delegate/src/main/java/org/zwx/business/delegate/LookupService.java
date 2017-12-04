package org.zwx.business.delegate;

public class LookupService {

    private BusinessService ejbService;
    private BusinessService jmsService;

    public void setEjbService(BusinessService ejbService) {
        this.ejbService = ejbService;
    }

    public void setJmsService(BusinessService jmsService) {
        this.jmsService = jmsService;
    }


    public BusinessService getService(ServiceType serviceType) {
        switch (serviceType) {
            case EJB:
                return ejbService;
            case JMS:
                return jmsService;
            default:
                throw new IllegalStateException("no such service");
        }
    }
}
