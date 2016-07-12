package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/192/
 */

public class ComparePoints {

    private static final String FILE_NAME = TestData.PATH + "comparepoints.txt";

    public static void main (String[] args) throws IOException {
            File file = new File(args.length > 0 ? args[0] : FILE_NAME);
            BufferedReader buffer = new BufferedReader(new FileReader(file));
            String line;
            StringBuilder result = new StringBuilder();
            StringBuilder current = new StringBuilder(5);
            int direction1;
            int direction2;
            while ((line = buffer.readLine()) != null) {
                String[] input = line.trim().split(" ");
                direction1 = Integer.parseInt(input[0]) - Integer.parseInt(input[2]);
                direction2 = Integer.parseInt(input[1]) - Integer.parseInt(input[3]);
                if (direction1 == 0 && direction2 == 0) {
                    current.append("here");
                } else {
                    if (direction2 != 0) current.append(direction2 > 0 ? 'S' : 'N');
                    if (direction1 != 0) current.append(direction1 > 0 ? 'W' : 'E');
                }
                result.append(current).append('\n');
                current.setLength(0);
            }
            System.out.print(result);
            buffer.close();
        }
    }
