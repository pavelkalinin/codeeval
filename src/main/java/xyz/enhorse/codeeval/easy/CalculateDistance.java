package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.codeeval.com/open_challenges/99/
 */

public class CalculateDistance {
    private static final String FILE_NAME = TestData.path + "calculatedistance.txt";
    private static final Pattern PATTERN = Pattern.compile("-?\\d+");

    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        int[] dots = new int[4];
        int current, index;
        while ((line = buffer.readLine()) != null) {
            Matcher matcher = PATTERN.matcher(line);
            index = 0;
            while (matcher.find()) {
                dots[index++] = Integer.parseInt(matcher.group());
            }
            current = (int)Math.pow(((dots[0] - dots[2]) * (dots[0] - dots[2])
                    + (dots[1] - dots[3]) * (dots[1] - dots[3])), 0.5);
            result.append(current).append('\n');
        }
        System.out.print(result);
        buffer.close();
    }
}
