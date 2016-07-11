package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/220/
 */
public class TrickOrTreat {
    private static final String FILE_NAME =  TestData.path + "trickortreat.txt";

    private static final int CANDIES_PER_VAMPIRE = 3;
    private static final int CANDIES_PER_ZOMBIE = 4;
    private static final int CANDIES_PER_WITCH = 5;

    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            String[] parts = line.split(", ");
            int vampires = Integer.valueOf((parts[0].split(" "))[1]);
            int zombies = Integer.valueOf((parts[1].split(" "))[1]);
            int witches = Integer.valueOf((parts[2].split(" "))[1]);
            int houses = Integer.valueOf((parts[3].split(" "))[1]);
            long current = vampires * CANDIES_PER_VAMPIRE + zombies * CANDIES_PER_ZOMBIE + witches * CANDIES_PER_WITCH;
            result.append(current * houses / (vampires + zombies + witches)).append('\n');
        }
        System.out.print(result);
        buffer.close();
    }
}
