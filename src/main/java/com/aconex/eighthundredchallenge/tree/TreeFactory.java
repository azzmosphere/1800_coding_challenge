package com.aconex.eighthundredchallenge.tree;

import com.aconex.eighthundredchallenge.mapper.CharacterMapper;

/**
 * Created by aaron.spiteri on 25/09/2016.
 */
public class TreeFactory {
    private CharacterMapper mapper = new CharacterMapper();
    private NodeFactory factory = new NodeFactory();
    private Node tree;

    /**
     * Creates the tree using the first dictionary word.
     *
     * @param word
     * @return tree
     */
    // Pretty much implements the standard algoritm, just sets the initial node.
    public Node createTree(String word) {
        for (char c : word.toCharArray()) {
            if (mapper.hasChar(c)) {
                tree = factory.createNode(mapper.getCharacterBitmap(c));
                appendWord(tree, word);
                break;
            }
        }

        return tree;
    }

    /**
     * append a word the tree, ignoring any non alpha characters.
     *
     * @param n
     * @param word
     */
    public void appendWord(Node n, String word) {

        boolean parentSet = false;
        int i = 0;
        for (char c : word.toCharArray()) {
            i++;
            // skip anything that is not known to the mapper.
            if (!mapper.hasChar(c)) {
                continue;
            }

            if (!parentSet) {
                n = factory.createParentNode(n, mapper.getCharacterBitmap(c));
                parentSet = true;
                continue;
            }

            // The last letter of a word could be a sibling or a child, the factory
            // will need to test for this.
            if (i == word.length()) {
                n = factory.attachChild(n, mapper.getCharacterBitmap(c), true);
                continue;
            }

            n = factory.attachChild(n, mapper.getCharacterBitmap(c));
        }
    }

}
