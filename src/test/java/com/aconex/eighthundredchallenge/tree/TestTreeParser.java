package com.aconex.eighthundredchallenge.tree;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by aaron.spiteri on 25/09/2016.
 */
public class TestTreeParser {

    private static final String filename = "/Users/aaron.spiteri/tmp/dictionary.txt";

    @Test
    public void shouldParseDictionay() throws Exception {
        Node tree = TreeParser.createTree(filename);

        assertTrue(true);
    }

}
