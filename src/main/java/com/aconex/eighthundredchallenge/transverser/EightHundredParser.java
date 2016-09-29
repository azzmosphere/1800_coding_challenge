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

    private void transverse(WordBuilder wb, Node currentNode) {
        if (currentNode == null)  {
            words.add(wb.getWord());
            return;
        }

        System.out.println(currentNode.getCharacterBitmap().getKey());

        if (currentNode.getSibling() != null) {
            transverse(WordBuilderFactory.cloneWordBuilder(wb), currentNode.getSibling());
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
