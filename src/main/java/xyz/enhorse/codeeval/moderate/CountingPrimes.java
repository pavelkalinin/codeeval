package xyz.enhorse.codeeval.moderate;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/63/
 */

public class CountingPrimes {

    private static final String FILE_NAME = TestData.PATH + "countingprimes.txt";

    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        int counter, current, max;
        while ((line = buffer.readLine()) != null) {
            String[] input = line.trim().split(",");
            current = Integer.parseInt(input[0]);
            max = Integer.parseInt(input[1]);
            counter = current <= 2 ? 1 : 0;
            while (current <= max) {
                if (millerRabinPass(2, current) && (current <= 7 || millerRabinPass(7, current)) && (current <= 61 || millerRabinPass(61, current))) {
                    counter++;
                }
                current++;
            }
            result.append(counter).append('\n');
        }
        System.out.print(result);
        buffer.close();
    }

    private static int modularExponent(int base, int power, int modulus) {
        long result = 1;
        for (int i = 31; i >= 0; i--) {
            result = (result * result) % modulus;
            if ((power & (1 << i)) != 0) {
                result = (result * base) % modulus;
            }
        }
        return (int)result;
    }

    private static boolean millerRabinPass(int a, int n) {
        int d = n - 1;
        int s = Integer.numberOfTrailingZeros(d);
        d >>= s;
        int a_to_power = modularExponent(a, d, n);
        if (a_to_power == 1) return true;
        for (int i = 0; i < s - 1; i++) {
            if (a_to_power == n - 1) return true;
            a_to_power = modularExponent(a_to_power, 2, n);
        }
        return a_to_power == n - 1;
    }
}
