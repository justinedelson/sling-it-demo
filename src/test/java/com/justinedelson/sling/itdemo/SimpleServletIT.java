package com.justinedelson.sling.itdemo;

import java.io.IOException;

import org.apache.sling.commons.testing.integration.HttpTestBase;

/**
 * @author justin
 *
 */
public class SimpleServletIT extends HttpTestBase {

    public void testSimpleServlet() throws IOException {
        final String expected = "Hello World!";
        final String content = getContent(HTTP_BASE_URL + "/test/from/this/bundle.txt", CONTENT_TYPE_PLAIN);
        assertTrue("Content contains " + expected + " (" + content + ")", content.contains(expected));
    }

}
