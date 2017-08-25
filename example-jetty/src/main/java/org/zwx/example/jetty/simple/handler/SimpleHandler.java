package org.zwx.example.jetty.simple.handler;

import org.eclipse.jetty.http.HttpStatus;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SimpleHandler extends AbstractHandler {
    //参数s代表什么？
    //第一个request包含什么，有什么内容，怎么利用它？？？
    @Override
    public void handle(String s, Request request, HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse) throws IOException, ServletException {
        httpServletResponse.setContentType("text/html; charset=utf-8");
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);


        PrintWriter pw = httpServletResponse.getWriter();
        pw.write("<h1>Hello World</h1>");

        //setHandled(true)有何用意，表示handler链结束？？？
        request.setHandled(true);
    }
}
