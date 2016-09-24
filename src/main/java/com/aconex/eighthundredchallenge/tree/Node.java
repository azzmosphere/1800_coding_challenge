package com.aconex.eighthundredchallenge.tree;

import com.aconex.eighthundredchallenge.mapper.CharacterBitmap;

/**
 * Created by aaron.spiteri on 25/09/2016.
 */
public class Node {
    private Node lhs; // within the same word
    private Node rhs; // when RHS is selected than the node on left should be forgotten.
    private CharacterBitmap characterBitmap;

    public Node getLhs() {
        return lhs;
    }

    public void setLhs(Node lhs) {
        this.lhs = lhs;
    }

    public Node getRhs() {
        return rhs;
    }

    public void setRhs(Node rhs) {
        this.rhs = rhs;
    }

    public CharacterBitmap getCharacterBitmap() {
        return characterBitmap;
    }

    public void setCharacterBitmap(CharacterBitmap characterBitmap) {
        this.characterBitmap = characterBitmap;
    }
}
