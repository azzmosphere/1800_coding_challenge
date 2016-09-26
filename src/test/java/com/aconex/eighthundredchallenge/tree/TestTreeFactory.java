package com.aconex.eighthundredchallenge.tree;

import com.aconex.eighthundredchallenge.mapper.CharacterBitmap;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by aaron.spiteri on 25/09/2016.
 */
public class TestTreeFactory {

    private TreeFactory tfactory = new TreeFactory();

    @Test
    public void shouldCreateTree1() {
        String word = "Call";
        Node tree = tfactory.createTree(word);

        assertThat(tree.getCharacterBitmap(), is(CharacterBitmap.C_C));
        assertThat(tree.getChild().getCharacterBitmap(), is(CharacterBitmap.C_A));
        assertThat(tree.getChild()
                        .getChild().getCharacterBitmap(),
                is(CharacterBitmap.C_L)
        );

        assertThat(tree.getChild()
                        .getChild()
                        .getChild().getCharacterBitmap(),
                is(CharacterBitmap.C_L)
        );
    }

    @Test
    public void shouldCreateTree2() {
        String word = "C all";
        Node tree = tfactory.createTree(word);

        assertThat(tree.getCharacterBitmap(), is(CharacterBitmap.C_C));
        assertThat(tree.getChild().getCharacterBitmap(), is(CharacterBitmap.C_A));
        assertThat(tree.getChild()
                        .getChild().getCharacterBitmap(),
                is(CharacterBitmap.C_L)
        );

        assertThat(tree.getChild()
                        .getChild()
                        .getChild().getCharacterBitmap(),
                is(CharacterBitmap.C_L)
        );
    }

    @Test
    public void shouldCreateTree3() {
        String word = "C a223ll";
        Node tree = tfactory.createTree(word);

        assertThat(tree.getCharacterBitmap(), is(CharacterBitmap.C_C));
        assertThat(tree.getChild().getCharacterBitmap(), is(CharacterBitmap.C_A));
        assertThat(tree.getChild()
                        .getChild().getCharacterBitmap(),
                is(CharacterBitmap.C_L)
        );

        assertThat(tree.getChild()
                        .getChild()
                        .getChild().getCharacterBitmap(),
                is(CharacterBitmap.C_L)
        );
    }

    @Test
    public void shouldCreateTree4() {
        String word = "556C a223ll";
        Node tree = tfactory.createTree(word);

        assertThat(tree.getCharacterBitmap(), is(CharacterBitmap.C_C));
        assertThat(tree.getChild().getCharacterBitmap(), is(CharacterBitmap.C_A));
        assertThat(tree.getChild()
                        .getChild().getCharacterBitmap(),
                is(CharacterBitmap.C_L)
        );

        assertThat(tree.getChild()
                        .getChild()
                        .getChild().getCharacterBitmap(),
                is(CharacterBitmap.C_L)
        );
    }
}
