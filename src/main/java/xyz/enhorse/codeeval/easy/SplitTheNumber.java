package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.codeeval.com/open_challenges/131/
 */

public class SplitTheNumber {
    public static final int BUFFER_SIZE = 1024;
    private static final String FILE_NAME = TestData.PATH + "splitthenumber.txt";
    private static final Pattern PATTERN = Pattern.compile("(\\d+)\\s([a-z]+)([-+])([a-z]+)");


    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        FileInputStream buffer = new FileInputStream(file);
        byte[] input = new byte[BUFFER_SIZE];
        int inputLength;
        StringBuilder result = new StringBuilder();
        StringBuilder line = new StringBuilder();
        Matcher matcher;
        int first, second;
        while ((inputLength = buffer.read(input)) != -1) {
            for (int i = 0; i < inputLength; i++) {
                if ((input[i] == '\n') || ((inputLength == i + 1) && (inputLength < input.length))) {
                    matcher = PATTERN.matcher(line.toString());
                    while (matcher.find()) {
                        first = Integer.parseInt(matcher.group(1).substring(0, matcher.group(2).length()));
                        second = Integer.parseInt(matcher.group(1).substring(matcher.group(2).length(), matcher.group(1).length()));
                        result.append(matcher.group(3).equals("+") ? first + second : first - second).append('\n');
                    }
                    line.setLength(0);

                } else {
                    line.append((char) input[i]);
                }
            }
        }
        System.out.print(result);
        buffer.close();
    }
}