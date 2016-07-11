package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/183/
 */

public class Details {
    private static final String FILE_NAME =  TestData.path + "details.txt";

    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            if (line.contains("XY")) {
                result.append('0');
            } else {
                result.append(getShift(line));
            }
            result.append('\n');
        }
        System.out.print(result);
        buffer.close();
    }

    private static int getShift(String string) {
        int result = Integer.MAX_VALUE;
        int posDot, posY;
        String[] rows = string.split(",");
        for (String row : rows) {
            char[] elements = row.toCharArray();
            posDot = -1;
            posY = -1;
            for (int i = 0; i < elements.length; i++) {
                if (elements[i] == '.' && posDot == -1)  {
                    posDot = i;
                }
                if (elements[i] == 'Y')  {
                    posY = i;
                    break;
                }
            }
            if (result > posY - posDot) {
                result = posY - posDot;
            }
        }
        return result;
    }
}
