package org.zwx.business.delegate;

public class BusinessDelegate {
    private LookupService lookupService;

    private ServiceType serviceType;

    public BusinessDelegate(LookupService lookupService) {
        this.lookupService = lookupService;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public void doTask() {
        BusinessService businessService = lookupService.getService(serviceType);
        businessService.doProcess();
    }
}
