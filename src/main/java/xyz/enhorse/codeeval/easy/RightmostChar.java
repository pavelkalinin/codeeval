package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/31/
 */

public class RightmostChar {
    private static final String FILE_NAME =  TestData.path + "rightmostchar.txt";

    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            result.append(getPos(line)).append('\n');
        }
        System.out.print(result);
        buffer.close();
    }

    private static int getPos(String line) {
        String[] parts = line.trim().split(",");
        return parts[0].lastIndexOf(parts[1].charAt(0));
    }
}
