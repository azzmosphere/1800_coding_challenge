package com.aconex.eighthundredchallenge.transverser;

import com.aconex.eighthundredchallenge.mapper.DigitMapper;
import com.aconex.eighthundredchallenge.tree.Node;

import java.util.ArrayList;

/**
 * Created by aaron.spiteri on 26/09/2016.
 */
public class EightHundredParser {
    private Node tree;
    private ArrayList<String> words = new ArrayList<>();
    private DigitMapper mapper = new DigitMapper();

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
        parseString(ph, 0, tree);
    }

    public void parseString(String ph, int pos, Node currentNode) {
        if (currentNode.getSibling() != null) {
            parseString(ph, pos, currentNode.getSibling());
        }
    }
}
