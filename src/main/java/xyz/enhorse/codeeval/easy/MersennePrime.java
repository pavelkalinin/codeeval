package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:pavel13kalinin@gmail.com">Pavel Kalinin</a>
 *         09.08.2016
 */
public class MersennePrime {

    private static final String FILE_NAME = TestData.PATH + "MersennePrime.txt";

    private List<Integer> primes;


    private MersennePrime(final int max) {
        initialisePrimes(max);
    }


    private String solve(final String filename) throws IOException {
        StringBuilder result = new StringBuilder();

        File input = new File(filename);
        BufferedReader buffer = new BufferedReader(new FileReader(input));
        String line;
        int number;
        while ((line = buffer.readLine()) != null) {
            number = Integer.parseInt(line.trim());
            result.append(getMersennePrimeSmallerThan(number)).append('\n');
        }

        return result.toString();
    }


    private String getMersennePrimeSmallerThan(final int number) {
        StringBuilder result = new StringBuilder();

        int i = 1;
        int current;
        while ((current = (2 << i++) - 1) < number) {
            if (isPrime(current)) {
                result.append(current).append(',');
            }
        }

        return result.substring(0, result.length() - 1);
    }


    private List<Integer> initialisePrimes(final int max) {
        primes = new ArrayList<>();

        primes.add(2);
        primes.add(3);
        for (int i = 6; i < max; i += 6) {
            testAndAdd(i - 1);
            testAndAdd(i + 1);
        }

        return Collections.unmodifiableList(primes);
    }


    private void testAndAdd(int i) {
        if (isPrime(i)) {
            primes.add(i);
        }
    }


    private boolean isPrime(int i) {
        int squareRoot = (int) Math.sqrt(i);

        for (Integer prime : primes) {
            if (prime > squareRoot) {
                break;
            }
            if (i % prime == 0) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) throws IOException {
        MersennePrime task = new MersennePrime(3000);
        System.out.print(task.solve(args.length > 0 ? args[0] : FILE_NAME));
    }
}
