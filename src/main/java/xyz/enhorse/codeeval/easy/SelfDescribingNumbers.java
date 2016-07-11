package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/40/
 */

public class SelfDescribingNumbers {
    private static final String FILE_NAME = TestData.path + "isselfdescribing.txt";
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        File inputFile = new File(args.length > 0 ? args[0] : FILE_NAME);
        FileInputStream buffer = new FileInputStream(inputFile);
        byte[] input = new byte[BUFFER_SIZE];
        int inputLength;

        StringBuilder result = new StringBuilder();
        StringBuilder current = new StringBuilder();
        int[] quantities = new int[10];
        byte valid;

        while ((inputLength = buffer.read(input)) != -1) {
            if (inputLength < BUFFER_SIZE && input[inputLength - 1] != '\n') {
                input[inputLength++] = '\n';
            }
            for (int i = 0; i < inputLength; i++) {
                if (input[i] == '\n') {
                    valid = 1;
                    for (int pos = 0; pos < current.length(); pos++) {
                        if (current.charAt(pos) - 0x30 != quantities[pos]) {
                            valid = 0;
                            break;
                        }
                    }
                    result.append(valid).append('\n');
                    for (int j = 0; j < quantities.length; j++) {
                        quantities[j] = 0;
                    }
                    current.setLength(0);
                } else {
                    quantities[input[i] - 0x30]++;
                    current.append((char) input[i]);
                }
            }
        }
        System.out.print(result);
        buffer.close();
    }
}
