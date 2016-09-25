package com.aconex.eighthundredchallenge.tree;

import com.aconex.eighthundredchallenge.mapper.CharacterBitmap;

/**
 * Created by aaron.spiteri on 25/09/2016.
 */
public class NodeFactory {

    // Inital node is the upper left most point, 0x0 on a planner graph
    public Node createNode(CharacterBitmap bitmap) {
        Node n = new Node();
        n.setCharacterBitmap(bitmap);
        return n;
    }

    public Node attachChild(Node parent, CharacterBitmap bitmap) {
        Node c = null;
        if (parent.getChild() == null) {
            c = createNode(bitmap);
            parent.setChild(c);
        }
        else if (parent.getChild().getCharacterBitmap().getBitMask() == bitmap.getBitMask()) {
            c = parent.getChild();
        }
        else {
            c = createNode(bitmap);
            parent.getChild().setSibling(c);
        }
        c.setParent(parent);

        return c;
    }

    public Node createParentNode(Node n, CharacterBitmap bitmap) {
        Node parent = null;

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
