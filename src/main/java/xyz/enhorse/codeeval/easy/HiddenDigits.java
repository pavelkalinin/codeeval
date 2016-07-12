package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/122/
 */

public class HiddenDigits {

    private static final String FILE_NAME = TestData.PATH + "hiddendigits.txt";
    private static final int BUFFER_SIZE = 1024;
    private static final String NONE = "NONE";

    public static void main(String[] args) throws IOException {
        File inputFile = new File(args.length > 0 ? args[0] : FILE_NAME);
        FileInputStream buffer = new FileInputStream(inputFile);
        byte[] input = new byte[BUFFER_SIZE];
        int inputLength;

        StringBuilder result = new StringBuilder();
        StringBuilder current = new StringBuilder();

        while ((inputLength = buffer.read(input)) != -1) {
            if (inputLength < BUFFER_SIZE && input[inputLength - 1] != '\n') {
                input[inputLength++] = '\n';
            }
            for (int i = 0; i < inputLength; i++) {
                if (input[i] == '\n') {
                    result.append(current.length() > 0 ? current : NONE).append('\n');
                    current.setLength(0);
                } else if (input[i] >= 'a' && input[i] <= 'j') {
                    current.append((char) (input[i] - 49));
                } else if (input[i] >= '0' && input[i] <= '9') {
                    current.append((char) input[i]);
                }
            }
        }
        System.out.print(result);
        buffer.close();
    }
}