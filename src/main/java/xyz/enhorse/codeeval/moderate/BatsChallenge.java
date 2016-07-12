package xyz.enhorse.codeeval.moderate;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.BitSet;

/**
 * https://www.codeeval.com/open_challenges/146/
 */
public class BatsChallenge {
    private static final int WIRE_BLEED = 6;
    private static final String FILE_NAME = TestData.PATH + "BatsChallenge.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        BitSet wire = new BitSet();

        while ((line = buffer.readLine()) != null) {
            String[] parameters = line.trim().split(" ");
            int length = Integer.parseInt(parameters[0]) + 1;
            int d = Integer.parseInt(parameters[1]);
            int bats = Integer.parseInt(parameters[2]);

            wire.clear();
            wire.set(0, WIRE_BLEED, true);
            wire.set(length - WIRE_BLEED, length, true);
            for (int i = 0; i < bats; i++) {
                int bat = Integer.parseInt(parameters[3 + i]);
                wire.set(bat - d + 1 >= 0 ? bat - d + 1 : 0,
                        bat + d <= length ? bat + d : length,
                        true);
            }

            int bats2add = 0;
            while (wire.cardinality() < length) {
                bats2add++;
                int clear = wire.nextClearBit(0);
                wire.set(clear - d + 1 >=0 ? clear - d + 1: 0, clear + d < length ? clear + d : length, true);
            }
            result.append(bats2add).append('\n');
        }
        System.out.print(result);
        buffer.close();
    }
}
