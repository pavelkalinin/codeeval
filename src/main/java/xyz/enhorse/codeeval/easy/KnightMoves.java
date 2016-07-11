package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/180/
 */

public class KnightMoves {
    private static final String FILE_NAME =  TestData.path + "knightmoves.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            int x = line.charAt(0) - 0x60;
            int y = line.charAt(1) - 0x30;
            for (int i = -2; i < 3; i++) {
                if (i == 0) {
                    continue;
                }
                int j = i % 2 == 0 ? 1 : 2;
                if ((x + i) > 0 && (x + i) < 9) {
                    if ((y - j) > 0) {
                        result.append((char)(x + i + 0x60)).append(y - j).append(' ');
                    }
                    if ((y + j) < 9) {
                        result.append((char)(x + i + 0x60)).append(y + j).append(' ');
                    }
                }
            }
            result.deleteCharAt(result.length() - 1).append('\n');
        }
        System.out.print(result);
        buffer.close();
    }
}
