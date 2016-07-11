package xyz.enhorse.codeeval.moderate;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/17/
 */
public class SumOfIntegers {
    private static final String FILE_NAME = TestData.path + "sumofintegers.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            final int[] numbers = convertInput(line);
            result.append(calculateLargestSumOfContiguousIntegers(numbers)).append('\n');
        }
        System.out.print(result);
        buffer.close();
    }

    private static int[] convertInput(final String input) {
        String[] numbers = input.split(",");
        int[] result = new int[numbers.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(numbers[i]);
        }
        return result;
    }

    public static long calculateLargestSumOfContiguousIntegers(int[] array) {
        assert array.length != 0;

        long result = array[0];
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                long current = sumOf(array, i, j);
                if (current > result) {
                    result = current;
                }
                if (current < 0) {
                    break;
                }
            }
        }
        return result;
    }

    private static long sumOf(int[] array, int from, int to) {
        long result = 0;
        for (int i = from; i <= to; i++) {
            result += array[i];
        }
        return result;
    }
}
