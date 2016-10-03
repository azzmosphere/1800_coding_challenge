package com.aconex.eighthundredchallenge.transverser;

import com.aconex.eighthundredchallenge.mapper.DigitMapper;
import com.aconex.eighthundredchallenge.tree.Node;

import java.util.ArrayList;

import static com.aconex.eighthundredchallenge.transverser.WordBuilderFactory.cloneWordBuilder;
import static com.aconex.eighthundredchallenge.transverser.WordBuilderFactory.createWordBuilder;

/**
 *
 * Responsible for transversing the dictionary tree and adding any complete words to the getWords() array.
 *
 * Created by aaron.spiteri on 26/09/2016.
 */
public class EightHundredParser {
    private ArrayList<String> words = new ArrayList<>();
    private DigitMapper mapper = new DigitMapper();
    private Node root;

    /**
     * Removes any non numeric characters from numeric string (phone number).
     *
     * @param ph
     * @return formatted phone number
     */
    public String preParse(String ph) {
        StringBuilder sb = new StringBuilder();
        for (char c : ph.toCharArray()) {
            if (mapper.hasChar(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * parse the phone number through the tree and produce results, this method will implicitly call the preParse
     * method.
     *
     * @param ph
     * @param tree
     */
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

        if (wb.isBoundrySet()) {
            wb.removeLastBoundry();
        }
    }

    private boolean append(WordBuilder wb, Node currentNode) {
        if (!wb.append(currentNode.getCharacterBitmap())) {

            if (!wb.isSlotsFilled() && wb.currentDigit().getBitMask() == 0) {
                wb.appendForce(wb.currentDigit());
                return wb.append(currentNode.getCharacterBitmap());
            }

            return false;
        }
        return true;
    }

    private void transverse(WordBuilder wb, Node currentNode) {
        if (currentNode == null) {
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
        else if (append(wb, currentNode)) {
            transverse(wb, currentNode.getChild());
        }
    }

    public String[] getWords() {
        return words.toArray(new String[words.size()]);
    }
}
