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

    private void transverseChild(WordBuilder wb, Node currentNode) {
        if (currentNode == null)  {
            if (wb.isSlotsFilled()) {
                words.add(wb.getWord());
            }
            return;
        }
        else if (wb.isSlotsFilled()) {
            return;
        }
        else if (!wb.append(currentNode.getCharacterBitmap())) {
            return;
        }
        transverse(wb, currentNode.getChild());
    }

    private void transverse(WordBuilder wb, Node currentNode) {
        transverseChild(wb, currentNode);
    }

    public String[] getWords() {
        return words.toArray(new String[words.size()]);
    }
}
