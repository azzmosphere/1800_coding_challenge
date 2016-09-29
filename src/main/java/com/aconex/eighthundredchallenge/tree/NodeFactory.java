package com.aconex.eighthundredchallenge.tree;

import com.aconex.eighthundredchallenge.mapper.CharacterBitmap;

/**
 * Created by aaron.spiteri on 25/09/2016.
 */
public class NodeFactory {

    /**
     * Create a node given a bitmap.
     *
     * @param bitmap
     * @return node
     */
    public Node createNode(CharacterBitmap bitmap) {
        Node n = new Node();
        n.setCharacterBitmap(bitmap);
        return n;
    }

    /**
     * attach a child node to a relative parent node. if the child node is the last character then create it
     * as a sibling of the parent.
     *
     * @param parent
     * @param bitmap
     * @return child node.
     */
    public Node attachChild(Node parent, CharacterBitmap bitmap) {
        Node c;
        if (parent.getChild() == null) {
            c = createNode(bitmap);
            parent.setChild(c);
        }
        else if (parent.getChild().getCharacterBitmap().getBitMask() == bitmap.getBitMask()) {

            // word has ended.
            if (parent.getChild().getChild() == null) {
                parent.getChild().setSibling(createNode(bitmap));
                c = parent.getChild().getSibling();
            }
            else {
                c = parent.getChild();
            }
        }
        else {
            c = createNode(bitmap);
            parent.getChild().setSibling(c);
        }
        c.setParent(parent);

        return c;
    }

    /**
     * Create a parent node, the first letter in the word.
     *
     * @param n
     * @param bitmap
     * @return parent node.
     */
    public Node createParentNode(Node n, CharacterBitmap bitmap) {
        Node parent;

        if (n == null) {
            parent = createNode(bitmap);
        }
        else if (n.getCharacterBitmap().getBitMask() == bitmap.getBitMask()) {
            parent = n;
        }
        else {
            parent = createNode(bitmap);
            n.setSibling(parent);
        }

        return parent;
    }

    /**
     * Given a node 'n' find the further most parent node, first character of a given word.
     *
     * @param n
     * @return grandparent node.
     */
    public Node getGrandParent(Node n) {
        Node grandparent;
        if (n.getParent() == null) {
            grandparent = n;
        }
        else {
            grandparent = getGrandParent(n.getParent());
        }

        return grandparent;
    }

}
