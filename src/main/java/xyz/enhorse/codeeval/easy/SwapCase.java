package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/96/
 */

public class SwapCase {
    public static final int BUFFER_SIZE = 1024;
    private static final String FILE_NAME = TestData.PATH + "swapcase.txt";


    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        FileInputStream buffer = new FileInputStream(file);
        byte[] input = new byte[BUFFER_SIZE];
        int inputLength;
        StringBuilder result = new StringBuilder();
        int ch;
        while ((inputLength = buffer.read(input)) != -1) {
            for (int i = 0; i < inputLength; i++) {
                if (input[i] >= 'a' && input[i] <= 'z') {
                    ch = input[i] - 32;
                } else if (input[i] >= 'A' && input[i] <= 'Z') {
                    ch = input[i] + 32;
                    } else {
                        ch = input[i];
                    }
                result.append((char) ch);
            }
        }
        System.out.print(result);
        buffer.close();
    }
}