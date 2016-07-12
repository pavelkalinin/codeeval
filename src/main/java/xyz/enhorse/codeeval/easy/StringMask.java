package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/199/
 */
public class StringMask {

    private static final String FILE_NAME = TestData.PATH + "StringMask.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            String[] parameters = line.trim().split(" ");
            for (int i = 0; i < parameters[0].length(); i++) {
                char c = parameters[0].charAt(i);
                result.append(parameters[1].charAt(i) == '0' ? Character.toLowerCase(c) : Character.toUpperCase(c));
            }
            result.append('\n');
        }
        System.out.print(result);
        buffer.close();
    }
}

