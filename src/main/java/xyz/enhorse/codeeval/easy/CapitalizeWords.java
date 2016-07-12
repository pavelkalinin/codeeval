package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/93/
 */

public class CapitalizeWords {

    public static final String FILE_NAME = TestData.PATH + "capitalizewords.txt";
    public static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        FileInputStream buffer = new FileInputStream(file);
        byte[] input = new byte[BUFFER_SIZE];
        int inputLength;
        StringBuilder result = new StringBuilder();
        int previousSymbol = -1;
        while ((inputLength = buffer.read(input)) != -1) {
            for (int i = 0; i < inputLength; i++) {
                if (previousSymbol == ' ' || previousSymbol == '\n' || previousSymbol == -1) {
                    if (input[i] >= 'a' && input[i] <= 'z') {
                        input[i] -= 32;
                    }
                }
                previousSymbol = input[i];
                result.append((char) previousSymbol);
            }
        }
        System.out.println(result);
        buffer.close();
    }
}
