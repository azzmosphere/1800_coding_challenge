package com.aconex.eighthundredchallenge.tree;

import com.aconex.eighthundredchallenge.mapper.CharacterBitmap;

/**
 * Created by aaron.spiteri on 25/09/2016.
 */
public class Node {
    private Node parent;
    private Node child;
    private Node sibling;
    private CharacterBitmap characterBitmap;

    public CharacterBitmap getCharacterBitmap() {
        return characterBitmap;
    }

    public void setCharacterBitmap(CharacterBitmap characterBitmap) {
        this.characterBitmap = characterBitmap;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getChild() {
        return child;
    }

    public void setChild(Node child) {
        this.child = child;
    }

    public Node getSibling() {
        return sibling;
    }

    public void setSibling(Node sibling) {
        this.sibling = sibling;
    }
}
