package xyz.enhorse.codeeval.moderate;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/223/
 */
public class AlternativeReality {

    private static final String FILE_NAME = TestData.PATH + "alternativereality.txt";
    private static final int[] COINS = {1, 5, 10, 25, 50};

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            final int change = Integer.parseInt(line);
            result.append(calculateWaysToChangeDP(change)).append('\n');
        }
        System.out.print(result);
        buffer.close();
    }

    private static int calculateWaysToChangeDP(int change) {
        int n = 0;
        for (int coin50 = 0; coin50 <= change / 50; coin50++) {
            for (int coin25 = 0; coin25 <= (change - coin50 * 50) / 25; coin25++) {
                for (int coin10 = 0; coin10 <= (change - coin50 * 50 - coin25 * 25) / 10; coin10++) {
                    for (int coin5 = 0; coin5 <= (change - coin50 * 50 - coin25 * 25 - coin10 * 10) / 5; coin5++) {
                        n++;
                    }
                }
            }
        }
        return n;
    }

    private static int calculateWaysToChangeRecursion(int change, int indexOfCoin) {
        if (change < 0 || indexOfCoin < 0) return 0;
        if (change == 0 || indexOfCoin == 0) return 1;
        return calculateWaysToChangeRecursion(change, indexOfCoin - 1)
                + calculateWaysToChangeRecursion(change - COINS[indexOfCoin], indexOfCoin);
    }


}
