package com.aconex.eighthundredchallenge.transverser;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

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

}
