package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/22/
 */

public class FibonacciSeries {
    private static final String FILE_NAME =  TestData.path + "fibonacciseries.txt";

    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            result.append(fibonacci(Integer.parseInt(line.trim()))).append('\n');
        }
        System.out.print(result);
        buffer.close();
    }

    public static long fibonacci(int n) {
        return n >= 0
                ? (long)((Math.pow(((1 + Math.sqrt(5)) / 2), n) - Math.pow(((1 - Math.sqrt(5)) / 2), n)) / Math.sqrt(5))
                : 0;
    }
}
