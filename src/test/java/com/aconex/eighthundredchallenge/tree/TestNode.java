package com.aconex.eighthundredchallenge.tree;

import com.aconex.eighthundredchallenge.mapper.CharacterBitmap;
import org.junit.Test;


import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by aaron.spiteri on 25/09/2016.
 */
public class TestNode {

    @Test
    public void shouldSetBitmask() {
        Node n = new Node();
        n.setCharacterBitmap(CharacterBitmap.C_A);
        assertTrue(n.getCharacterBitmap().getBitMask() == 1);
        assertTrue(n.getCharacterBitmap().getKey() == 'A');
    }


    @Test
    public void shouldSetSibling() {
        Node p = new Node(), s = new Node();
        p.setSibling(s);

        assertThat(p.getSibling(), is(s));
    }

    @Test
    public void shouldSetParent() {
        Node p = new Node(), s = new Node();
        s.setParent(p);

        assertThat(s.getParent(), is(p));
    }

    @Test
    public void souldSetChild() {
        Node p = new Node(), s = new Node();
        p.setChild(s);

        assertThat(p.getChild(), is(s));
    }

}
