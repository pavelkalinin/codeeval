package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/147/
 */

public class LetterCasePercentage {
    private static final String FILE_NAME = TestData.path + "lettercasepercentage.txt";
    private static final int BUFFER_SIZE = 1024;
    private static final String OUTPUT_FORMAT_STRING = "lowercase: %.2f uppercase: %.2f\n";

    public static void main(String[] args) throws IOException {
        File inputFile = new File(args.length > 0 ? args[0] : FILE_NAME);
        FileInputStream buffer = new FileInputStream(inputFile);
        byte[] input = new byte[BUFFER_SIZE];
        int inputLength;

        StringBuilder result = new StringBuilder();
        StringBuilder current = new StringBuilder();
        double lowerCasePercent, quantity;

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
                        quantity = 0;
                        for (int index = 0; index < current.length(); index++) {
                            if (Character.isLowerCase(current.charAt(index))) {
                                quantity++;
                            }
                        }
                        lowerCasePercent = current.length() > 0 ? quantity / current.length() * 100 : 0;
                        result.append(String.format(OUTPUT_FORMAT_STRING, lowerCasePercent, 100 - lowerCasePercent));
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

