package com.aconex.eighthundredchallenge;

import com.aconex.eighthundredchallenge.exceptions.TreeParserException;
import com.aconex.eighthundredchallenge.transverser.EightHundredParser;
import com.aconex.eighthundredchallenge.tree.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static com.aconex.eighthundredchallenge.tree.TreeParser.createTree;

/**
 *
 * Main class for the eight hundred challenge, implements the main() method and coordinates the parser and
 * the transverser.
 *
 * Created by aaron.spiteri on 2/10/2016.
 */
public class EightHundredChallenge {

    private Node tree;

    private EightHundredChallenge(String dictionaryFile) throws TreeParserException {
        tree = createTree(dictionaryFile);
    }

    private void process(String number) {
        EightHundredParser parser = new EightHundredParser();
        parser.parse(number, tree);

        System.out.println("Words for number :" + number);
        System.out.println("++++");
        for (String word : parser.getWords()) {
            System.out.println(word);
        }
        System.out.println();
    }

    private void process(ArrayList<String> numbers) {

        for (String number : numbers) {
            process(number);
        }
    }

    private void processStdIn() throws Exception {
        boolean quit = false;
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a phone number to check, or type 'quit' to exit");

        while (!quit) {
            String num = stdin.readLine();
            if ("quit".equals(num)) {
                quit = true;
            } else {
                process(num);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ArrayList<String> nums = new ArrayList<>();
        String dictionary = null;

        for (int i = 0; i < args.length; i++) {
            if ("-d".equals(args[i])) {
                i++;
                dictionary = args[i];
            } else {
                nums.add(args[i]);
            }
        }

        System.out.println("dictionary = " + dictionary);

        try {
            EightHundredChallenge eightHundredChallenge = new EightHundredChallenge(dictionary);

            if (nums.size() > 0) {
                eightHundredChallenge.process(nums);
            } else {
                eightHundredChallenge.processStdIn();
            }
        } catch (TreeParserException ex) {
            System.out.println("ERROR: Dictionary file can not be read");
        } catch (Exception e) {
            System.out.println("ERROR: A IO exception has occurred while reading input - " + e.getMessage());
        }
    }
}
