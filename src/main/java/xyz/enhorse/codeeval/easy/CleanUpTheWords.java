package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/205/
 */
public class CleanUpTheWords {
    private static final String FILE_NAME =  TestData.path + "cleanupthewords.txt";

    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        boolean needToAddSpace;
        int currentLength;
        while ((line = buffer.readLine()) != null) {
            needToAddSpace = false;
            currentLength = 0;
            for (int i = 0; i < line.length(); i++) {
                if (Character.isLetter(line.charAt(i))) {
                    if (needToAddSpace) {
                        result.append(' ');
                        needToAddSpace = false;
                    }
                    result.append(Character.toLowerCase(line.charAt(i)));
                    currentLength++;
                } else {
                    if (currentLength != 0) {
                        needToAddSpace = true;
                    }
                }
            }
            result.append('\n');
        }
        System.out.print(result);
        buffer.close();
    }
}
