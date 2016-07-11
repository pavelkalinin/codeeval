package xyz.enhorse.codeeval.moderate;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/32/
 */
public class TrailingString {
    private static final String FILE_NAME = TestData.path + "TrailingString.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        boolean current;
        int commaPosition;
        while ((line = buffer.readLine()) != null) {
            current = false;
            commaPosition = line.lastIndexOf(",");
            String tail = line.substring(commaPosition + 1);
            if (line.length() > (tail.length() * 2)) {
                current = line.substring(commaPosition - tail.length(), commaPosition).equals(tail);
            }
            result.append(current ? '1' : '0').append('\n');
        }
        System.out.print(result);
        buffer.close();
    }
}
