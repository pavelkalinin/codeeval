package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.codeeval.com/open_challenges/18/
 */

public class MultiplyNumber {

    private static final String FILE_NAME = TestData.PATH + "multiplynumbers.txt";
    private static final Pattern PATTERN = Pattern.compile("(\\d+),(\\d+)");

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        int current, base, number;
        Matcher matcher;
        while ((line = buffer.readLine()) != null) {
            matcher = PATTERN.matcher(line);
            matcher.find();
            number = Integer.parseInt(matcher.group(1));
            base = Integer.parseInt(matcher.group(2));
            if (number % base == 0) {
                current = number;
            } else {
                current = (number / base + 1) * base;
            }
            result.append(current).append('\n');
        }
        System.out.print(result);
        buffer.close();
    }
}