package com.aconex.eighthundredchallenge.tree;

import com.aconex.eighthundredchallenge.mapper.EightHundredBitMap;

/**
 * A graph node for a character in the tree.
 *
 * Created by aaron.spiteri on 25/09/2016.
 */
public class Node {
    private Node parent;
    private Node child;
    private Node sibling;
    private EightHundredBitMap characterBitmap;

    /**
     * Get the character bit map.
     *
     * @return bit map.
     */
    public EightHundredBitMap getCharacterBitmap() {
        return characterBitmap;
    }

    /**
     * set the character bitmap.
     *
     * @param characterBitmap
     */
    public void setCharacterBitmap(EightHundredBitMap characterBitmap) {
        this.characterBitmap = characterBitmap;
    }

    /**
     * Return the parent Node
     *
     * @return
     */
    public Node getParent() {
        return parent;
    }

    /**
     * Set the parent node.
     *
     * @param parent
     */
    public void setParent(Node parent) {
        this.parent = parent;
    }

    /**
     * Return the child node.
     *
     * @return
     */
    public Node getChild() {
        return child;
    }

    /**
     * Set the child node.
     *
     * @param child
     */
    public void setChild(Node child) {
        this.child = child;
    }

    /**
     * Return the sibling node
     *
     * @return
     */
    public Node getSibling() {
        return sibling;
    }

    /**
     * Set the sibling node.
     *
     * @param sibling
     */
    public void setSibling(Node sibling) {
        this.sibling = sibling;
    }
}
