package com.justinedelson.sling.itdemo;

import java.io.IOException;

import org.apache.sling.commons.testing.integration.HttpTestBase;

/**
 * @author justin
 *
 */
public class InitialContentIT extends HttpTestBase {

    public void testIndex() throws IOException {
        final String expected = "Do not remove this comment, used for Launchpad integration tests";
        final String content = getContent(HTTP_BASE_URL + "/index.html", CONTENT_TYPE_HTML);
        assertTrue("Content contains expected marker (" + content + ")", content.contains(expected));
    }

    public void testRootRedirectProperty() throws IOException {
        final String expected = "\"sling:resourceType\":\"sling:redirect\"";
        final String content = getContent(HTTP_BASE_URL + "/.json", CONTENT_TYPE_JSON);
        assertTrue("Content contains " + expected + " (" + content + ")", content.contains(expected));
    }

    public void testInitialContentA() throws IOException {
        final String expected = "42";
        final String content = getContent(HTTP_BASE_URL + "/sling-test/sling/initial-content-test/marker.txt",
                CONTENT_TYPE_PLAIN);
        assertTrue("Content contains " + expected + " (" + content + ")", content.contains(expected));
    }

    public void testInitialContentB() throws IOException {
        final String expected = "46";
        final String content = getContent(HTTP_BASE_URL
                + "/sling-test/initial-content-folder/folder-content-test/marker.txt", CONTENT_TYPE_PLAIN);
        assertTrue("Content contains " + expected + " (" + content + ")", content.contains(expected));
    }
}
