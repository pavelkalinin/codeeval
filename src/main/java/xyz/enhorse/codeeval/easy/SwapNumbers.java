package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/196/
 */
public class SwapNumbers {

    private static final String FILE_NAME = TestData.PATH + "SwapNumbers.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            String[] words = line.trim().split(" ");
            for (int i = 0; i < words.length; i++) {
                char[] word = words[i].toCharArray();
                char first = word[0];
                word[0] = word[word.length - 1];
                word[word.length - 1] = first;
                result.append(word);
                if (i != words.length - 1) {
                    result.append(' ');
                }
            }
            result.append('\n');
        }
        System.out.print(result);
        buffer.close();
    }
}
