package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/100/
 */

public class EvenNumbers {
    public static final int BUFFER_SIZE = 1024;
    private static final String FILE_NAME = TestData.PATH + "evennumbers.txt";

    public static void main(String[] args) throws IOException {
        File inputFile = new File(args.length > 0 ? args[0] : FILE_NAME);
        FileInputStream buffer = new FileInputStream(inputFile);
        byte[] input = new byte[BUFFER_SIZE];
        int inputLength;
        StringBuilder result = new StringBuilder();
        int value = -1;
        while ((inputLength = buffer.read(input)) != -1) {
            for (int i = 0; i < inputLength; i++) {
                if (inputLength < BUFFER_SIZE && input[inputLength - 1] != '\n') {
                    input[inputLength++] = '\n';
                }
                if (input[i] >= '0' && input[i] <= '9') {
                    value = input[i];
                } else {
                    if (input[i] == '\n') {
                        result.append((value - '0') % 2 == 0 ? '1' : '0').append('\n');
                    }
                }
            }
        }
        System.out.print(result);
        buffer.close();
    }
}
