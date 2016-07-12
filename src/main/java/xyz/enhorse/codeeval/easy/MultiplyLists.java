package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/113/
 */

public class MultiplyLists {

    private static final String FILE_NAME = TestData.PATH + "multiplylists.txt";

    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            String[] parts = line.split("\\|");
            String[] list1 = parts[0].trim().split(" ");
            String[] list2 = parts[1].trim().split(" ");
            for (int i = 0; i < list1.length; i++) {
                result.append(Integer.parseInt(list1[i]) * Integer.parseInt(list2[i])).append(' ');
            }
            result.append('\n');
        }
        System.out.print(result);
        buffer.close();
    }

}
