package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/189/
 */

public class MinimumDistance {

    private static final String FILE_NAME = TestData.PATH + "minimumdistance.txt";
    private static final int BUFFER_SIZE = 1024;
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 10000;
    private static final int MAX_FRIENDS = 99;

    public static void main(String[] args) throws IOException {
        File inputFile = new File(args.length > 0 ? args[0] : FILE_NAME);
        FileInputStream buffer = new FileInputStream(inputFile);
        byte[] input = new byte[BUFFER_SIZE];
        int inputLength;
        StringBuilder result = new StringBuilder();
        StringBuilder current = new StringBuilder(String.valueOf(MAX_NUMBER - MIN_NUMBER - 1).length());
        int[] points = new int[MAX_FRIENDS];
        int max = MIN_NUMBER, min = MAX_NUMBER, index = 0;
        while ((inputLength = buffer.read(input)) != -1) {
            if (inputLength < BUFFER_SIZE && input[inputLength - 1] != '\n') {
                input[inputLength++] = '\n';
            }
            for (int i = 0; i < inputLength; i++) {
                switch (input[i]) {
                    case '\r': {
                        continue;
                    }
                    case ' ':
                    case '\n': {
                        if (current.length() == 0) {
                            continue;
                        }
                        points[index] = Integer.parseInt(current.toString());
                        if (index != 0) {
                            if (points[index] > max) {
                                max = points[index];
                            }
                            if (points[index] < min) {
                                min = points[index];
                            }
                        }
                        index++;
                        current.setLength(0);
                        if (input[i] == '\n') {
                            result.append(getMinSum(points, max, min)).append('\n');
                            index = 0;
                            min = MAX_NUMBER;
                            max = MIN_NUMBER;
                        }
                        break;
                    }
                    default: {
                        current.append((char) input[i]);
                    }
                }

            }
        }
        System.out.print(result);
        buffer.close();
    }

    private static int getMinSum(int[] points, int max, int min) {
        int minSum = MAX_NUMBER * points[0];
        int currentSum;
        for (int i = min; i <= max; i++) {
            currentSum = 0;
            for (int j = 1; j <= points[0]; j++) {
                currentSum += Math.abs(points[j] - i);
            }
            if (currentSum < minSum) {
                minSum = currentSum;
            }
        }
        return minSum;
    }
}