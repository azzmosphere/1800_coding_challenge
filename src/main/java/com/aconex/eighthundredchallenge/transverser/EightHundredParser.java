package com.aconex.eighthundredchallenge.transverser;

import com.aconex.eighthundredchallenge.mapper.DigitMapper;
import com.aconex.eighthundredchallenge.tree.Node;

import java.util.ArrayList;

import static com.aconex.eighthundredchallenge.transverser.WordBuilderFactory.cloneWordBuilder;
import static com.aconex.eighthundredchallenge.transverser.WordBuilderFactory.createWordBuilder;

/**
 * Created by aaron.spiteri on 26/09/2016.
 */
public class EightHundredParser {
    private ArrayList<String> words = new ArrayList<>();
    private DigitMapper mapper = new DigitMapper();
    Node root;

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
        WordBuilder wb = createWordBuilder(ph, mapper);
        transverse(wb, tree);
    }

    private void transverseSetBoundry(WordBuilder wb, Node currentNode) {
        if (!wb.isBoundrySet()) {
            wb.setBoundry();
        }

        transverse(wb, currentNode);

        // Remove the last boundry if it exists.
        if (wb.isBoundrySet()) {
            wb.removeLastBoundry();
        }
    }

    private void transverse(WordBuilder wb, Node currentNode) {
        if (currentNode == null)  {
            if (!wb.isSlotsFilled()) {
                transverseSetBoundry(wb, root);
            }
            else {
                words.add(wb.getWord());
            }
            return;
        }

        else if (currentNode.getSibling() != null) {
            transverse(cloneWordBuilder(wb), currentNode.getSibling());
        }

        if (wb.isSlotsFilled()) {
            return;
        }

        else if (wb.append(currentNode.getCharacterBitmap())) {
            transverse(wb, currentNode.getChild());
        }
    }

    public String[] getWords() {
        return words.toArray(new String[words.size()]);
    }
}
