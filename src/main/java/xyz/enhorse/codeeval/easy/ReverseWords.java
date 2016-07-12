package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/8/
 */

public class ReverseWords {

    private static final String FILE_NAME = TestData.PATH + "reversewords.txt";

    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            String[] words = line.trim().split(" ");
            for (int i = words.length; i > 0; i--) {
                result.append(words[i - 1]).append(' ');
            }
            result.deleteCharAt(result.length() - 1);
            result.append('\n');
        }
        System.out.print(result);
    }

}
