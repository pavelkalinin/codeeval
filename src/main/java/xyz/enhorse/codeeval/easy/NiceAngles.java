package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/160/
 */

public class NiceAngles {
    private static final String FILE_NAME =  TestData.path + "niceangles.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        int degrees;
        double minutes, seconds, value;
        while ((line = buffer.readLine()) != null) {
            value = Double.valueOf(line);
            degrees = (int)value;
            value -= degrees;
            minutes = value * 60;
            seconds = (minutes - (int) minutes) * 60;
            result.append(String.format("%d.%02d\'%02d\"\n", degrees, (int) minutes, (int) seconds));
        }
        System.out.print(result);
        buffer.close();
    }
}
