package xyz.enhorse.codeeval.moderate;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * https://www.codeeval.com/open_challenges/41/
 */

public class ArrayAbsurdity {

    private static final String FILE_NAME = TestData.PATH + "arrayabsurdity.txt";

    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            System.out.println(getDuplicate(line));
        }
    }

    private static int getDuplicate(String line) {
        String numbersLine = line.substring(line.indexOf(';') + 1, line.length());
        String[] parts = numbersLine.split(",");
        Set<String> numbers = new HashSet<>();
        int result = 0;
        for (String element : parts) {
            result = numbers.size();
            numbers.add(element);
            if (result == numbers.size()) {
                result = Integer.parseInt(element);
                break;
            }
        }
        return result;
    }
}
