package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/173/
 */

public class WithoutRepetitions {
    private static final String FILE_NAME =  TestData.path + "withoutrepetitions.txt";

    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        int value;
        StringBuilder result = new StringBuilder();
        while((value = buffer.read()) != -1)
        {
            if ((result.length() == 0) || (result.charAt(result.length() - 1) != (char) value)) {
                result.append((char) value);
            }
        }
        System.out.println(result);
        buffer.close();
    }
}
