package com.aconex.eighthundredchallenge.tree;

import com.aconex.eighthundredchallenge.mapper.CharacterBitmap;
import com.aconex.eighthundredchallenge.mapper.CharacterMapper;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by aaron.spiteri on 25/09/2016.
 */
public class TestNodeFactory {

    CharacterMapper mapper = new CharacterMapper();
    NodeFactory factory = new NodeFactory();

    @Test
    public void shouldMapWord1() {
        String words[] = {"CALL", "CAT", "ME"};
        Node n, initial = createTree(words);

        // Word is "CALL"
        assertThat(initial.getCharacterBitmap(), is(CharacterBitmap.C_C));
        n = initial.getChild();
        assertThat(n.getCharacterBitmap(), is(CharacterBitmap.C_A));
        n = n.getChild();
        assertThat(n.getCharacterBitmap(), is(CharacterBitmap.C_L));
        n = n.getChild();
        assertThat(n.getCharacterBitmap(), is(CharacterBitmap.C_L));

        // Word is "ME"
        n = factory.getGrandParent(n).getSibling();
        assertThat(n.getCharacterBitmap(), is(CharacterBitmap.C_M));
        n = n.getChild();
        assertThat(n.getCharacterBitmap(), is(CharacterBitmap.C_E));

        // Word is "CAT"
        n = initial.getChild().getChild().getSibling();
        assertThat(n.getCharacterBitmap(), is(CharacterBitmap.C_T));
    }

    @Test
    public void shouldCreateSibling() {
        String words[] = {"CALL", "CALLED"};
        Node n, initial = createTree(words);

        // Word is "CALL"
        assertThat(initial.getCharacterBitmap(), is(CharacterBitmap.C_C));
        n = initial.getChild();
        assertThat(n.getCharacterBitmap(), is(CharacterBitmap.C_A));
        n = n.getChild();
        assertThat(n.getCharacterBitmap(), is(CharacterBitmap.C_L));
        n = n.getChild();
        assertThat(n.getCharacterBitmap(), is(CharacterBitmap.C_L));

        n = n.getSibling();
        assertThat(n.getCharacterBitmap(), is(CharacterBitmap.C_L));
    }

    private Node createTree(String[] words) {
        Node initial = null, n = null;
        boolean foundInitial = false;

        for (String word : words) {
            int i = 0;
            for (char c : word.toCharArray()) {
                i++;
                CharacterBitmap bitmap = mapper.getCharacterBitmap(c);

                if (!foundInitial) {
                    n = factory.createParentNode(n, bitmap);
                    foundInitial = true;

                    if (initial == null) {
                        initial = n;
                    }
                } else if (i == word.length()) {
                    n = factory.attachChild(n, bitmap);
                } else {
                    n = factory.attachChild(n, bitmap);
                }
            }
            n = factory.getGrandParent(n);
            foundInitial = false;
        }
        return initial;
    }

}
