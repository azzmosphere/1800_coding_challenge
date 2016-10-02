package com.aconex.eighthundredchallenge;

import com.aconex.eighthundredchallenge.exceptions.TreeParserException;
import com.aconex.eighthundredchallenge.transverser.EightHundredParser;
import com.aconex.eighthundredchallenge.tree.Node;

import java.util.ArrayList;

import static com.aconex.eighthundredchallenge.tree.TreeParser.createTree;

/**
 * Created by aaron.spiteri on 2/10/2016.
 */
public class EightHundredChallenge {

    private String dictionaryFile;
    private ArrayList<String> numbers;

    private EightHundredChallenge(String dictionaryFile, ArrayList<String> numbers) {
        this.dictionaryFile = dictionaryFile;
        this.numbers = numbers;
    }

    private void process() {
        try {
            Node tree = createTree(dictionaryFile);
            EightHundredParser parser = new EightHundredParser();

            for (String number : numbers) {
                parser.parse(number, tree);

                System.out.println("Words for number :" + number);
                System.out.println("++++");
                for (String word : parser.getWords()) {
                    System.out.println(word);
                }
            }
            System.out.println();
        }
        catch (TreeParserException ex) {
            System.out.println("ERROR: Dictionary file can not be read");
        }
    }

    public static void main(String[] args) {
        ArrayList<String> nums = new ArrayList<>();
        String dictionary = null;

        for (int i = 0; i < args.length; i++) {
            if ("-d".equals(args[i])) {
                i++;
                dictionary = args[i];
            }
            else {
                nums.add(args[i]);
            }
        }

        System.out.println("dictionary = " + dictionary);

        new EightHundredChallenge(dictionary, nums).process();
    }
}
