package com.aconex.eighthundredchallenge.transverser;

import org.junit.Test;
import com.aconex.eighthundredchallenge.tree.Node;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static com.aconex.eighthundredchallenge.tree.TreeParser.createTree;

/**
 * Created by aaron.spiteri on 27/09/2016.
 */
public class TestEightHundredParser {

    @Test
    public void shouldPreParse() {

        EightHundredParser parser = new EightHundredParser();
        String s1 = "1.2.34 5";

        assertThat(parser.preParse(s1), is("12345"));
    }

    @Test
    public void shouldTransverseChild() {
        EightHundredParser parser = new EightHundredParser();
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
        EightHundredParser parser = new EightHundredParser();
        String[] dictionary = {"CALL", "CALK", "CALJ", "CDLL"};
        String digitString = "2255";
        Node tree = createTree(dictionary);
        parser.parse(digitString, tree);

        assertThat(parser.getWords()[0], is("CALL"));
        assertThat(parser.getWords()[1], is("CALK"));
        assertThat(parser.getWords()[2], is("CALJ"));
    }

    @Test
    public void shouldSetBoundry() {
        EightHundredParser parser = new EightHundredParser();
        String[] dictionary = {"CALL", "CALLME", "ME", "CDLL"};
        String digitString = "2255.63";
        Node tree = createTree(dictionary);
        parser.parse(digitString, tree);


        assertThat(parser.getWords()[0], is("CALLME"));
        assertThat(parser.getWords()[1], is("CALL-ME"));
    }

    @Test
    public void shouldSetDigit() {
        EightHundredParser parser = new EightHundredParser();
        String[] dictionary = {"CALLME"};
        String digitString = "22551.63";
        Node tree = createTree(dictionary);
        parser.parse(digitString, tree);

        assertThat(parser.getWords()[0], is("CALL1ME"));

    }

    @Test
    public void shouldSetDigit2() {
        EightHundredParser parser = new EightHundredParser();
        String[] dictionary = {"CALLME"};
        String digitString = "225511.63";
        Node tree = createTree(dictionary);
        parser.parse(digitString, tree);

        assertThat(parser.getWords().length, is(0));
    }

    @Test
    public void shouldSetDigit3() {
        EightHundredParser parser = new EightHundredParser();
        String[] dictionary = {"CALLME"};
        String digitString = "202551.63";
        Node tree = createTree(dictionary);
        parser.parse(digitString, tree);

        assertThat(parser.getWords()[0], is("C0ALL1ME"));
    }

    @Test
    public void shouldFindAllWords() {
        EightHundredParser parser = new EightHundredParser();
        String[] dictionary = {"CALL ME", "CALL", "ME"};
        String digitString = "2255.63";
        Node tree = createTree(dictionary);
        parser.parse(digitString, tree);

        assertThat(parser.getWords()[0], is("CALLME"));
        assertThat(parser.getWords()[1], is("CALL-ME"));
    }

    @Test
    public void shouldFindAllWords2() {
        EightHundredParser parser = new EightHundredParser();
        String[] dictionary = {"CALL ME", "CALL ME", "CALL", "ME"};
        String digitString = "2255.63";
        Node tree = createTree(dictionary);
        parser.parse(digitString, tree);

        assertThat(parser.getWords()[0], is("CALLME"));
        assertThat(parser.getWords()[1], is("CALL-ME"));
    }
}
