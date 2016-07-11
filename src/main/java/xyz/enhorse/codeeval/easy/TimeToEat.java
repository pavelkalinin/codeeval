package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

/**
 * https://www.codeeval.com/open_challenges/214/
 */
public class TimeToEat {
    private static final String FILE_NAME =  TestData.path + "timetoeat.txt";

    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            String[] timeStamps = line.split(" ");
            Arrays.sort(timeStamps, Collections.reverseOrder());
            for (String timeStamp : timeStamps) {
                result.append(timeStamp).append(' ');
            }
            result.append('\n');
        }
        System.out.println(result);
        buffer.close();
    }
}