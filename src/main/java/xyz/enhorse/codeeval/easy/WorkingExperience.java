package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.codeeval.com/open_challenges/139/
 */

public class WorkingExperience {
    private static final String FILE_NAME =  TestData.path + "workingexpirience.txt";
    private static final Pattern PATTERN = Pattern.compile("([A-Z][a-z]{2})\\s*(\\d{4})-([A-Z][a-z]{2})\\s*(\\d{4})");
    public static final int MONTHS_PER_YEAR = 12;
    public static final int START = 1990;
    public static final int LAST = 2021;
    public static final int BUFFER_SIZE = 1024;
    private static final Map<String, Integer> MONTHS = new HashMap<String, Integer>(MONTHS_PER_YEAR) {
        {
            put("Jan", 1);
            put("Feb", 2);
            put("Mar", 3);
            put("Apr", 4);
            put("May", 5);
            put("Jun", 6);
            put("Jul", 7);
            put("Aug", 8);
            put("Sep", 9);
            put("Oct", 10);
            put("Nov", 11);
            put("Dec", 12);
        }
    };

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        FileInputStream buffer = new FileInputStream(file);
        byte[] input = new byte[BUFFER_SIZE];
        int inputLength;
        StringBuilder result = new StringBuilder();
        BitSet experience = new BitSet((LAST - START) * MONTHS_PER_YEAR);
        StringBuilder line = new StringBuilder();
        Matcher matcher;
        int from, to;
        while ((inputLength = buffer.read(input)) != -1) {
            for (int i = 0; i < inputLength; i++) {
                if ((input[i] == '\n') || ((inputLength == i + 1) && (inputLength < input.length))) {
                    matcher = PATTERN.matcher(line.toString());
                    while (matcher.find()) {
                        from = (Integer.valueOf(matcher.group(2)) - START) * MONTHS_PER_YEAR
                                + MONTHS.get(matcher.group(1));
                        to = (Integer.valueOf(matcher.group(4)) - START) * MONTHS_PER_YEAR
                                + MONTHS.get(matcher.group(3));
                        experience.set(from, to + 1);
                    }
                    result.append((experience.cardinality()) / MONTHS_PER_YEAR).append('\n');
                    experience.clear();
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