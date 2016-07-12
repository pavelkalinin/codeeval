package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/227/
 */

public class RealFake {

    private static final String FILE_NAME = TestData.PATH + "realfake.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            boolean isOdd = true;
            char[] digits = line.toCharArray();
            int sum = 0;
            for (char digit : digits) {
                if (digit != ' ') {
                    int current = digit - 0x30;
                    if (isOdd) {
                        sum += current * 2;
                        isOdd = false;
                    } else {
                        sum += current;
                        isOdd = true;
                    }
                }
            }
            if ((sum % 10) == 0) {
                result.append("Real\n");
            } else {
                result.append("Fake\n");
            }
        }
        buffer.close();
        result.setLength(result.length() - 1);
        System.out.print(result);
    }
}
