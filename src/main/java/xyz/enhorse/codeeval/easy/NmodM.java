package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/62/
 */

public class NmodM {
    private static final String FILE_NAME = TestData.path + "nmodm.txt";
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        File inputFile = new File(args.length > 0 ? args[0] : FILE_NAME);
        FileInputStream buffer = new FileInputStream(inputFile);
        byte[] input = new byte[BUFFER_SIZE];
        int inputLength;
        StringBuilder result = new StringBuilder();
        StringBuilder current = new StringBuilder();
        int number = -1, base;
        while ((inputLength = buffer.read(input)) != -1) {
            if (inputLength < BUFFER_SIZE && input[inputLength - 1] != '\n') {
                input[inputLength++] = '\n';
            }
            for (int i = 0; i < inputLength; i++) {
                switch (input[i]) {
                    case '\r': {
                        continue;
                    }
                    case ',':
                    case '\n': {
                        base = Integer.parseInt(current.toString());
                        current.setLength(0);
                        if (input[i] == '\n') {
                            result.append(number - (number / base) * base).append('\n');
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
}
