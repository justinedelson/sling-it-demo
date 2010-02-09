package com.justinedelson.sling.itdemo.impl;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;

/**
 * @author justin
 *
 */
@Component(metatype=false)
@Service
@Property(name="sling.servlet.paths", value={"/test/from/this/bundle.txt"})
public class SimpleServlet extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,
            IOException {
        response.setContentType("text/plain");
        response.getWriter().println("Hello World!");
        response.getWriter().flush();
    }

}
