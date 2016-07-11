package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/225/
 */
public class Testing {
    private static final String FILE_NAME = TestData.path+"testing.txt";
    private static final String[] ERRORS_LEVEL =
            {"Done", "Low", "Low", "Medium", "Medium", "High", "High", "Critical"};

    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            String[] input = line.trim().split(" \\| ");
            char[] first = input[0].toCharArray();
            char[] second = input[1].toCharArray();
            int errors = 0;
            for (int i = 0; i < first.length; i++) {
                if (first[i] != second[i]) {
                    errors++;
                }
                if (errors > 6) {
                    break;
                }
            }
            result.append(ERRORS_LEVEL[errors]).append('\n');
        }
        System.out.print(result);
        buffer.close();
    }
}
