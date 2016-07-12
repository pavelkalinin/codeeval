package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/103/
 */

public class LowestUniqueNumber {

    private static final String FILE_NAME = TestData.PATH + "lowestuniquenumber.txt";

    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            result.append(getLowest(line)).append('\n');
        }
        System.out.print(result);
        buffer.close();
    }

    private static int getLowest(String line) {
        String[] strings = line.split(" ");
        int[] numbers = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            numbers[i] = Integer.valueOf(strings[i]);
        }

        int[] digits = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int number : numbers) {
            digits[number - 1]++;
        }

        int result = 0;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 1) {
                result = i + 1;
                break;
            }
        }
        return result > 0 ? line.indexOf(String.valueOf(result)) / 2 + 1 : result;
    }

}
