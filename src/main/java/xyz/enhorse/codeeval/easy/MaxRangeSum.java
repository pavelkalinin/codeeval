package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/186/
 */

public class MaxRangeSum {

    private static final String FILE_NAME = TestData.PATH + "maxrangesum.txt";

    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        int period, currentMax, max;
        while ((line = buffer.readLine()) != null) {
            String[] parts = line.split(";");
            period = Integer.parseInt(parts[0]);
            String[] portfolio = parts[1].split(" ");
            int[] days = new int[portfolio.length];
            for (int i = 0; i < portfolio.length; i++) {
                days[i] = Integer.parseInt(portfolio[i]);
            }
            currentMax = 0;
            for (int i = 0; i < days.length - period + 1; i++) {
                max = 0;
                for (int j = i; j < i + period; j++) {
                    max += days[j];
                }
                if (max > currentMax) {
                    currentMax = max;
                }
            }
            result.append(currentMax).append('\n');
        }
        System.out.print(result);
    }
}
