package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/97/
 */

public class FindWriter {

    private static final String FILE_NAME = TestData.PATH + "findwriter.txt";

    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            String[] pair = line.split("\\|");
            result.append(decode(pair[0], parseKey(pair[1]))).append('\n');
        }
        System.out.print(result);
        buffer.close();
    }

    private static int[] parseKey(String key) {
        String[] numbers = key.trim().split(" ");
        int[] result = new int[numbers.length];
        for(int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(numbers[i]);
        }
        return result;
    }

    private static String decode(String value, int[] key) {
        StringBuilder result = new StringBuilder(key.length);
        for (int i : key) {
            result.append(value.charAt(i - 1));
        }
        return String.valueOf(result);
    }

}
