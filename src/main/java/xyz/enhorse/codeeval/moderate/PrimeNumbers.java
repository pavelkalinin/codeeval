package xyz.enhorse.codeeval.moderate;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.BitSet;

/**
 * https://www.codeeval.com/open_challenges/46/
 */
public class PrimeNumbers {
    private static final String FILE_NAME = TestData.path + "primenumbers.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            int number = Integer.parseInt(line);
            result.append(bitSetToString(computePrimes(number))).append('\n');
        }
        System.out.print(result);
    }

    private static BitSet computePrimes(int limit) {
        final BitSet primes = new BitSet();
        primes.set(0, false);
        primes.set(1, false);
        primes.set(2, limit, true);
        for (int i = 0; i * i < limit; i++) {
            if (primes.get(i)) {
                for (int j = i * i; j < limit; j += i) {
                    primes.clear(j);
                }
            }
        }
        return primes;
    }

    private static String bitSetToString(final BitSet bitset) {
        final StringBuilder result = new StringBuilder();
        int current = -1;
        while (true) {
            current = bitset.nextSetBit(++current);
            if (current == -1) {
                break;
            }
            result.append(current).append(',');
        }
        trimLastSymbol(result);
        return result.toString();
    }

    private static void trimLastSymbol(final StringBuilder result) {
        if (result.length() != 0) {
            result.setLength(result.length() - 1);
        }
    }
}
