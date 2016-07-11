package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/217/
 */
public class OneZeroTwoZeros {
    private static final String FILE_NAME = TestData.path + "onezerotwozeros.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            String[] values = line.split(" ");
            int zeros = Integer.parseInt(values[0]);
            int toNumber = Integer.parseInt(values[1]);
            int amount = 0;
            for (int i = 1; i <= toNumber; i++) {
                if (countZeroes(Integer.toBinaryString(i)) == zeros) {
                    amount++;
                }
            }
            result.append(amount).append('\n');
        }
        System.out.print(result);
        buffer.close();
    }

    private static int countZeroes(final String string) {
        int result = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '0') {
                result++;
            }
        }
        return result;
    }
}
