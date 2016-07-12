package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/156/
 */

public class RollerCoaster {
    public static final int BUFFER_SIZE = 1024;
    private static final String FILE_NAME = TestData.PATH + "rollercoaster.txt";


    public static void main (String[] args) throws IOException {
        StringBuilder result = new StringBuilder();
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        FileInputStream buffer = new FileInputStream(file);
        byte[] input = new byte[BUFFER_SIZE];
        boolean up = true;
        int inputLength;
        while ((inputLength = buffer.read(input)) != -1) {
            for (int i = 0; i < inputLength; i++) {
                char ch = (char) input[i];
                if (ch == '\n') {
                    up = true;
                }
                result.append(up ? Character.toUpperCase(ch) : Character.toLowerCase(ch));
                up = (((ch >= 'A') && (ch <= 'Z')) || ((ch >= 'a') && (ch <= 'z'))) != up;
            }
        }
        System.out.println(result);
        buffer.close();
    }
}
