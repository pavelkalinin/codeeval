package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.codeeval.com/open_challenges/115/
 */

public class MixedContent {
    private static final String FILE_NAME =  TestData.path + "mixedcontent.txt";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("(\\d+)");
    private static final Pattern WORD_PATTERN = Pattern.compile("([A-Za-z]+)");

    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        StringBuilder numbers = new StringBuilder();
        StringBuilder words = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            getMatches(NUMBER_PATTERN.matcher(line), numbers);
            getMatches(WORD_PATTERN.matcher(line), words);
            if (words.length() > 0) {
                words.setLength(words.length() - 1);
                if (numbers.length() > 0) words.append('|');
            }
            if (numbers.length() > 0) {
                numbers.setLength(numbers.length() - 1);
            }
            result.append(words).append(numbers).append('\n');
            numbers.setLength(0);
            words.setLength(0);
        }
        System.out.print(result);
        buffer.close();
    }

    private static void getMatches(Matcher matcher, StringBuilder result) {
        while (matcher.find()) {
            result.append(matcher.group()).append(',');
        }
    }
}