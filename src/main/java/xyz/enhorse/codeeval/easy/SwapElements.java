package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/112/
 */
public class SwapElements {

    private static final String FILE_NAME = TestData.PATH + "swapelements.txt";

    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            String[] parts = line.trim().split("[:]");
            String[] data = parts[0].trim().split(" ");
            int[][] pairs = getArray(parts[1].trim());
            for (int[] pair : pairs) {
                String temp = data[pair[0]];
                data[pair[0]] = data[pair[1]];
                data[pair[1]] = temp;
            }
            for (int i = 0; i < (data.length - 1); i++) {
                result.append(data[i]).append(' ');
            }
            result.append(data[data.length - 1]).append('\n');
        }
        System.out.print(result);
        buffer.close();
    }

    private static int[][] getArray(String s) {
        String[] parts = s.split("[,]");
        int[][] result = new int[parts.length][2];
        for (int i = 0; i < parts.length; i++) {
            String[] pair = parts[i].trim().split("-");
            result[i][0] = Integer.valueOf(pair[0]);
            result[i][1] = Integer.valueOf(pair[1]);
        }
        return result;
    }
}

