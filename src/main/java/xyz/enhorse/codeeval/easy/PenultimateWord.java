package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/92/
 */

public class PenultimateWord {

    private static final String FILE_NAME = TestData.PATH + "penultimateword.txt";
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        File inputFile = new File(args.length > 0 ? args[0] : FILE_NAME);
        FileInputStream buffer = new FileInputStream(inputFile);
        byte[] input = new byte[BUFFER_SIZE];
        int inputLength;
        StringBuilder result = new StringBuilder();
        StringBuilder current = new StringBuilder();
        StringBuilder previous = new StringBuilder();
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
                        previous.setLength(0);
                        previous.append(current);
                        current.setLength(0);
                        break;
                    }
                    case '\n': {
                        if (previous.length() == 0) {
                            previous.append(current);
                        }
                        result.append(previous).append('\n');
                        previous.setLength(0);
                        current.setLength(0);
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
