package org.zwx.controller;

import org.zwx.config.annotation.RestController;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@RestController
@Path("/rest")
public class TestController {

    @Path("/test")
    @POST
    public Response test(){
        String response = "ok";
        return Response.ok().entity(response).build();
    }
}
