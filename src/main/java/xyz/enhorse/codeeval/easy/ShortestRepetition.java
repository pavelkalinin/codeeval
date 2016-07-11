package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/107/
 */

public class ShortestRepetition {
    private static final String FILE_NAME = TestData.path + "shortestrepetitions.txt";
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        File inputFile = new File(args.length > 0 ? args[0] : FILE_NAME);
        FileInputStream buffer = new FileInputStream(inputFile);
        byte[] input = new byte[BUFFER_SIZE];
        int inputLength;
        StringBuilder result = new StringBuilder();
        StringBuilder current = new StringBuilder();
        StringBuilder checked = new StringBuilder();
        StringBuilder element = new StringBuilder();
        while ((inputLength = buffer.read(input)) != -1) {
            if (inputLength < BUFFER_SIZE && input[inputLength - 1] != '\n') {
                input[inputLength++] = '\n';
            }
            for (int i = 0; i < inputLength; i++) {
                switch (input[i]) {
                    case '\r': {
                        continue;
                    }
                    case '\n': {
                        int stringLength = current.length();
                        int shortest = stringLength;
                        for (int elementLength = 1; elementLength < stringLength; elementLength++) {
                            checked.setLength(0);
                            element.setLength(0);
                            for (int j = 0; j < elementLength; j++) {
                                element.append(current.charAt(j));
                            }
                            for (int j = 1; j <= stringLength / elementLength; j++) {
                                checked.append(element);
                            }
                            if (checked.toString().equals(current.toString())) {
                                shortest = element.length();
                                break;
                            }
                        }
                        result.append(shortest).append('\n');
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
