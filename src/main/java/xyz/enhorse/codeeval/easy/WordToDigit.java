package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/104/
 */

public class WordToDigit {
    private static final String FILE_NAME =  TestData.path + "wordtodigit.txt";

    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        String[] words;
        while ((line = buffer.readLine()) != null) {
            words = line.trim().split(";");
            for (String word : words) {
                result.append(getDigit(word));
            }
            result.append('\n');
        }
        System.out.print(result);
        buffer.close();
    }

    private static int getDigit(String value) {
        switch (value) {
            case "one": return 1;
            case "two": return 2;
            case "three": return 3;
            case "four": return 4;
            case "five": return 5;
            case "six": return 6;
            case "seven": return 7;
            case "eight": return 8;
            case "nine": return 9;
            default: return 0;
        }
    }
}
