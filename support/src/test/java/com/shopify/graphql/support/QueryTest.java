package com.shopify.graphql.support;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QueryTest {
    @Test
    public void testStringEscaping() throws Exception {
        StringBuilder result = new StringBuilder();
        Query.appendQuotedString(result, "\0 \r \n \\ \" c ꝏ");
        assertEquals("\"\\u0000 \\r \\n \\\\ \\\" c ꝏ\"", result.toString());
    }

    @Test
    public void testInvalidAlias() {
        boolean exceptionThrown = false;
        try {
            new Query<Query>(null) {
            }.withAlias("invalid__alias");
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        } finally {
            assertTrue(exceptionThrown);
        }
    }

    @Test
    public void testBlankAlias() {
        boolean exceptionThrown = false;
        try {
            new Query<Query>(null) {
            }.withAlias("");
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        } finally {
            assertTrue(exceptionThrown);
        }
    }
}
