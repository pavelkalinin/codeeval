package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/1/
 */

public class FizzBuzz {

    private static final String FILE_NAME = TestData.PATH + "fizzbuzz.txt";
    private static final int BUFFER_SIZE = 1024;
    private static final char FIZZ = 'F';
    private static final char BUZZ = 'B';
    private static final String EMPTY = "";
    private static final char DELIMITER = ' ';

    public static void main(String[] args) throws IOException {
        File inputFile = new File(args.length > 0 ? args[0] : FILE_NAME);
        FileInputStream buffer = new FileInputStream(inputFile);
        byte[] input = new byte[BUFFER_SIZE];
        int inputLength;
        StringBuilder result = new StringBuilder();
        StringBuilder current = new StringBuilder();
        int quantity, first = -1, second = -1;
        boolean isFirst = true;
        while ((inputLength = buffer.read(input)) != -1) {
            if (inputLength < BUFFER_SIZE && input[inputLength - 1] != '\n') {
                input[inputLength++] = '\n';
            }
            for (int i = 0; i < inputLength; i++) {
                switch (input[i]) {
                    case '\r': {
                        continue;
                    }
                    case ' ': {
                        if (isFirst) {
                            first = Integer.parseInt(current.toString());
                        } else {
                            second = Integer.parseInt(current.toString());
                        }
                        isFirst = !isFirst;
                        current.setLength(0);
                        break;
                    }
                    case '\n': {
                        quantity = Integer.parseInt(current.toString());
                        current.setLength(0);
                        for (int j = 1; j <= quantity; j++) {
                            current.append(j % first == 0 ? FIZZ : EMPTY).append(j % second == 0 ? BUZZ : EMPTY);
                            if (current.length() == 0) {
                                current.append(j);
                            }
                            result.append(current).append(DELIMITER);
                            current.setLength(0);
                        }
                        result.setLength(result.length() - 1);
                        result.append('\n');
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
}