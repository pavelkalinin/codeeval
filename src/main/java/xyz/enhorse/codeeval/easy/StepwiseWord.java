package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/202/
 */
public class StepwiseWord {
    private static final String FILE_NAME = TestData.path + "stepwiseword.txt";

    private static final String MAX_WORD_LENGTH = "**********";

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            String[] words = line.replace("| ", "").split(" ");
            result.append(stepwiseWord(getLongest(words))).append('\n');
        }
        System.out.print(result);
        buffer.close();
    }

    private static String stepwiseWord(String longest) {
        StringBuilder result = new StringBuilder();
        result.append(longest.substring(0, 1)).append(' ');
        for (int i = 1; i < longest.length(); i++) {
            result.append(MAX_WORD_LENGTH.substring(0, i)).append(longest.charAt(i)).append(' ');
        }
        return result.toString();
    }

    private static String getLongest(String[] words) {
        String result = words[0];
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > result.length()) {
                result = words[i];
            }
        }
        return result;
    }
}
