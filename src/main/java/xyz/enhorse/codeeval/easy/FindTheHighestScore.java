package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/208/
 */
public class FindTheHighestScore {

    private static final String FILE_NAME = TestData.PATH + "findthehighestscore.txt";

    public static void main (String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            String[] participants = line.split(" \\| ");
            int[] max = new int[countCategories(participants[0])];
            initMax(max);
            for (String participant : participants) {
                processParticipant(participant, max);
            }
            for (int i : max) {
                result.append(i).append(' ');
            }
            result.append('\n');
        }
        System.out.println(result);
        buffer.close();
    }

    private static void processParticipant(String participant, int[] max) {
        int index = 0;
        for (String score : participant.split(" ")) {
            int current = Integer.parseInt(score.trim());
            if (current > max[index]) {
                max[index] = current;
            }
            index++;
        }
    }

    private static void initMax(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.MIN_VALUE;
        }
    }

    private static int countCategories(String string) {
        int result = 1;
        for (char ch : string.toCharArray()) {
            if (ch == ' ') {
                result++;
            }
        }
        return result;
    }
}
