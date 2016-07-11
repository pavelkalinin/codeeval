package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/136/
 */

public class RacingChars {
    private static final String FILE_NAME =  TestData.path + "racingchars.txt";
    public static final int BUFFER_SIZE = 1024;
    private static final String[] PATH = {"/", "|", "\\"};

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        FileInputStream buffer = new FileInputStream(file);
        byte[] input = new byte[BUFFER_SIZE];
        int inputLength;
        StringBuilder result = new StringBuilder();
        StringBuilder line = new StringBuilder();
        int previous = -1, current;
        while ((inputLength = buffer.read(input)) != -1) {
            for (int i = 0; i < inputLength; i++) {
                if ((input[i] == '\n') || ((inputLength == i + 1) && (inputLength < input.length))) {
                    current = line.indexOf("C") > -1 ? line.indexOf("C") : line.indexOf("_");
                    if (previous == -1) {
                        previous = current;
                    }
                    line.replace(current, current + 1, PATH[current - previous + 1]);
                    result.append(line).append('\n');
                    previous = current;
                    line.setLength(0);
                } else {
                    line.append((char) input[i]);
                }
            }
        }
        System.out.print(result);
        buffer.close();
    }
}