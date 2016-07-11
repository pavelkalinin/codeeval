package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * https://www.codeeval.com/open_challenges/39/
 */

public class HappyNumbers {
    private static final String FILE_NAME =  TestData.path + "happynumbers.txt";

    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            long number = getSumOfSquares(Integer.parseInt(line.trim()));
            System.out.printf("%d\n", number);
        }
    }

    private static long getSumOfSquares(int number) {
        long result = number;
        Set<Integer> sums = new HashSet<>();
        boolean notHappy = false;
        while (result != 1 && !notHappy) {
            int[] digits = asDigits(result);
            int current = 0;
            for (int i : digits) {
                current += inPower2(i);
            }
            notHappy = sums.contains(current);
            sums.add(current);
            result = current;
        }
        return result == 1 ? 1 : 0;
    }

    public static int[] asDigits(long number) {
        int[] digits = new int[quantityOfDigits(number)];
        number = Math.abs(number);
        int index = digits.length - 1;
        for(long a = number; a > 0; a /= 10) {
            digits[index--] = (int)(a % 10);
        }
        return digits;
    }

    public static int quantityOfDigits(long number) {
        int quantityOfDigits = (number == 0) ? 1 : 0;
        number = Math.abs(number);
        for(long i = 0L; i < number; quantityOfDigits++) {
            i = (i << 3) + (i << 1) + 9L;
        }
        return quantityOfDigits;
    }

    private static int inPower2(int number) {
        return number * number;
    }
}
