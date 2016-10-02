package com.aconex.eighthundredchallenge.tree;

import com.aconex.eighthundredchallenge.mapper.CharacterBitmap;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by aaron.spiteri on 25/09/2016.
 */
public class TestTreeParser {

    private static final String filename = "/Users/aaron.spiteri/tmp/dictionary.txt";

    @Test
    public void shouldParseDictionaryObjects() throws Exception {
        String[] dictionary = {"CALL", "ME", "CALL ME"};
        Node tree = TreeParser.createTree(dictionary);

        assertThat(tree.getCharacterBitmap(), is(CharacterBitmap.C_C));
        assertThat(tree.getChild().getCharacterBitmap(), is(CharacterBitmap.C_A));
        assertThat(tree.getChild().getChild().getCharacterBitmap(), is(CharacterBitmap.C_L));
        assertThat(tree.getChild().getChild().getChild().getCharacterBitmap(), is(CharacterBitmap.C_L));
    }

}
