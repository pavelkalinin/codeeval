package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/111/
 */

public class LongestWord {

    private static final String FILE_NAME = TestData.PATH + "longestword.txt";

    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        StringBuilder longestWord = new StringBuilder();
        int length;
        while ((line = buffer.readLine()) != null) {
            String[] words = line.split(" ");
            length = words[0].length();
            longestWord.append(words[0]);
            for (String word : words) {
                if (length < word.length()) {
                    length = word.length();
                    longestWord.setLength(0);
                    longestWord.append(word);
                }
            }
            result.append(longestWord).append('\n');
        }
        System.out.print(result);
        buffer.close();
    }
}
