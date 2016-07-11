package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.codeeval.com/open_challenges/102/
 */

public class JsonMenuIDs {
    private static final String FILE_NAME =  TestData.path + "jsonmenuids.txt";
    private static final Pattern PATTERN = Pattern.compile("\"id\": (\\d+), \"label\"");

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        int sum;
        while ((line = buffer.readLine()) != null) {
            if (line.length() > 5) {
                sum = 0;
                Matcher matcher = PATTERN.matcher(line);
                while (matcher.find()) {
                    sum += Integer.valueOf(matcher.group(1));
                }
                result.append(sum).append('\n');
            }
        }
        System.out.print(result);
        buffer.close();
    }
}

