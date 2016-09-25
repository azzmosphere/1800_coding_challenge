package com.aconex.eighthundredchallenge.tree;

import com.aconex.eighthundredchallenge.mapper.CharacterMapper;

/**
 * Created by aaron.spiteri on 25/09/2016.
 */
public class TreeFactory {
    private CharacterMapper mapper = new CharacterMapper();
    private NodeFactory factory = new NodeFactory();
    private Node initial;

    // Pretty much implements the standard algoritm, just sets the initial node.
    public Node createTree(String word) {
        for (char c : word.toCharArray()) {
            if (mapper.hasChar(c)) {
                initial = factory.createNode(mapper.getCharacterBitmap(c));
                appendWord(initial, word);
                break;
            }
        }

        return initial;
    }

    public void appendWord(Node n, String word) {

        boolean parentSet = false;
        for (char c : word.toCharArray()) {

            // skip anything that does not fit.
            if (!mapper.hasChar(c)) {
                continue;
            }

            if (!parentSet) {
                n = factory.createParentNode(n, mapper.getCharacterBitmap(c));
                continue;
            }

            n = factory.attachChild(n, mapper.getCharacterBitmap(c));
        }
    }

}
