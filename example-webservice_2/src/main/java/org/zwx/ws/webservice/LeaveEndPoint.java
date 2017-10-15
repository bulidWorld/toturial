package org.zwx.ws.webservice;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.located.LocatedElement;
import org.jdom2.xpath.XPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.zwx.ws.service.api.HumanResourceService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Endpoint
public class LeaveEndPoint {
    private static final String NAME_SPACE = "http://zwx.com/hr/schemas";

    private XPath startDateExpress;

    private XPath endDateExpress;

    private XPath nameExpress;

    private HumanResourceService humanResourceService;

    @Autowired
    public LeaveEndPoint(HumanResourceService humanResourceService) throws JDOMException {
        this.humanResourceService = humanResourceService;

        Namespace namespace = Namespace.getNamespace("hr", NAME_SPACE);

        startDateExpress = XPath.newInstance("//hr:StartDate");
        startDateExpress.addNamespace(namespace);


        endDateExpress = XPath.newInstance("//hr:EndDate");

        endDateExpress.addNamespace(namespace);

        nameExpress = XPath.newInstance("concat(//hr:FirstName,' ',//hr:LastName)");
        nameExpress.addNamespace(namespace);
    }


    @PayloadRoot(namespace = NAME_SPACE, localPart = "LeaveRequest")
    @ResponsePayload
    public Element handleLeaveRequest(@RequestPayload Element leaveRequest) throws JDOMException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date startDate = sdf.parse(startDateExpress.valueOf(leaveRequest));
        Date end = sdf.parse(endDateExpress.valueOf(leaveRequest));
        String name = nameExpress.valueOf(leaveRequest);

        humanResourceService.bookLeave(startDate, end, name);


        Element resp = new LocatedElement("errorCode");
        resp.addContent("0");

        return resp;
    }

}
