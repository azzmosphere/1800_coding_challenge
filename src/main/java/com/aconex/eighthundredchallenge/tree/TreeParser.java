package com.aconex.eighthundredchallenge.tree;

import com.aconex.eighthundredchallenge.exceptions.TreeParserException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Parse string objects to the tree factory.
 *
 * Created by aaron.spiteri on 25/09/2016.
 */
public class TreeParser {

    /**
     * Parse a dictionary text file and convert it to a dictionary tree.
     *
     * @param filename
     * @return tree
     * @throws TreeParserException
     */
    public static Node createTree(String filename) throws TreeParserException {
        Node tree;
        try {
            tree = createTree(Files.lines(Paths.get(filename)).toArray());
        }
        catch (Exception e) {
            throw new TreeParserException(e.getMessage());
        }

        return tree;
    }

    /**
     * parse a array object of strings and convert them to a dictionary tree.
     *
     * @param objects
     * @return tree
     */
    public static Node createTree(Object[] objects) {
        TreeFactory tfactory = new TreeFactory();
        boolean treeCreated = false;
        Node tree = null;

        // Remove duplicates in dictionary and sort array for parsing.
        objects = new HashSet<>(Arrays.asList(objects)).toArray(new String[0]);
        Arrays.sort(objects);

        for (Object wordObject : objects) {
            String word = (String) wordObject;

            if (!treeCreated) {
                tree = tfactory.createTree(word);
                treeCreated = true;
            }
            else {
                tfactory.appendWord(tree, word);
            }
        }

        return tree;
    }


}
