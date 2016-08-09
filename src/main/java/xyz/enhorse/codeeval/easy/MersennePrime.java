package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author <a href="mailto:pavel13kalinin@gmail.com">Pavel Kalinin</a>
 *         09.08.2016
 */
public class MersennePrime {

    private static final String FILE_NAME = TestData.PATH + "MersennePrime.txt";


    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder();

        File input = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(input));
        String line;
        int number;
        while ((line = buffer.readLine()) != null) {
            number = Integer.parseInt(line.trim());
            result.append(getMersennePrimeSmallerThan(number)).append('\n');
        }

        System.out.print(result.substring(0, result.length() - 1));
    }


    private static String getMersennePrimeSmallerThan(final int number) {
        StringBuilder result = new StringBuilder();

        int i = 1;
        while (true) {
            int current = 2 << i++;

            if (current - 1 > number) {
                break;
            }

            if (isPrime(current - 1)) {
                result.append(current - 1).append(',');
            }
        }

        return result.substring(0, result.length() - 1);
    }


    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= number / i; i++) {
            if ((number % i) == 0) {
                return false;
            }
        }
        return true;
    }
}
