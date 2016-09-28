package com.aconex.eighthundredchallenge.transverser;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static com.aconex.eighthundredchallenge.tree.TreeParser.createTree;

/**
 * Created by aaron.spiteri on 27/09/2016.
 */
public class TestEightHundredParser {

    private EightHundredParser parser = new EightHundredParser();


    @Test
    public void shouldPreParse() {

        String s1 = "1.2.34 5";

        assertThat(parser.preParse(s1), is("12345"));
    }

    @Test
    public void shouldTransverseChild() {
        // String[] dictionary = {"CALL", "ME", "CALLME"};
        String[] dictionary = {"CALK"};
        String digitString = "2255";
        parser.parse(digitString, createTree(dictionary));
        assertThat(parser.getWords()[0], is("CALK"));

        parser = new EightHundredParser();
        String[] dictionary2 = {"CALA"};
        parser.parse(digitString, createTree(dictionary2));
        assertTrue(parser.getWords().length == 0);

        parser = new EightHundredParser();
        String[] dictionary3 = {"CALL"};
        parser.parse(digitString, createTree(dictionary3));
        assertThat(parser.getWords()[0], is("CALL"));

    }

    @Test
    public void shouldTransverseSibling() {
        String[] dictionary = {"ME", "CALL"};
        String digitString = "2255";
        EightHundredParser parser = new EightHundredParser();

        parser.parse(digitString, createTree(dictionary));
        assertThat(parser.getWords()[0], is("CALL"));
    }


    @Test
    public void shouldTransverseSibling2() {
        String[] dictionary = {"CALL", "CALK"};
        String digitString = "2255";
        EightHundredParser parser = new EightHundredParser();

        parser.parse(digitString, createTree(dictionary));


        assertThat(parser.getWords()[0], is("CALL"));
    }

}
