package com.aconex.eighthundredchallenge.transverser;

import com.aconex.eighthundredchallenge.mapper.DigitMapper;
import com.aconex.eighthundredchallenge.tree.Node;

import java.util.ArrayList;

/**
 * Created by aaron.spiteri on 26/09/2016.
 */
public class EightHundredParser {
    private ArrayList<String> words = new ArrayList<>();
    private DigitMapper mapper = new DigitMapper();
    Node root;
    private enum NODE_DIRECTION {
        SIBLING {
            @Override
            public Node getDirection(Node n) {
                return n.getSibling();
            }
        },
        CHILD {
            @Override
            public Node getDirection(Node n) {
                return n.getChild();
            }
        },
        PARENT {
            @Override
            public Node getDirection(Node n) {
                return n.getParent();
            }
        };

        public Node getDirection(Node n) {
            return null;
        }
    };

    public String preParse(String ph) {
        StringBuilder sb = new StringBuilder();
        for (char c : ph.toCharArray()) {
            if (mapper.hasChar(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public void parse(String ph, Node tree) {
        ph = preParse(ph);
        root = tree;
        WordBuilder wb = new WordBuilder(ph, mapper);
        transverse(wb, tree);
    }

    /**
     * Tranverses the tree in a specific direction, that is specified by
     *
     * @param wb
     * @param currentNode
     * @param nextNode
     */
    private boolean transverseDirection(WordBuilder wb, Node currentNode, NODE_DIRECTION nextNode) {
        if (currentNode == null)  {
            return true;
        }
        else if (wb.isSlotsFilled()) {
            return false;
        }
        else if (!wb.append(currentNode.getCharacterBitmap())) {
            return false;
        }
        return transverseDirection(wb, nextNode.getDirection(currentNode), nextNode);
    }

    /**
     * Transverses tree, searches children first, then searches
     * siblings
     *
     * @param wb
     * @param currentNode
     */
    private void transverse(WordBuilder wb, Node currentNode) {
        if (transverseDirection(wb, currentNode, NODE_DIRECTION.CHILD)) {
            if (wb.isSlotsFilled()) {
                words.add(wb.getWord());
            }
            else {
                wb.setBoundry();
                currentNode = root;
            }
        }

        if (!transverseDirection(wb, currentNode, NODE_DIRECTION.SIBLING)) {
            transverse(wb, currentNode.getSibling());
        }
    }

    public String[] getWords() {
        return words.toArray(new String[words.size()]);
    }
}
