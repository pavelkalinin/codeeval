package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * https://www.codeeval.com/open_challenges/83/
 */

public class BeautifulStrings {

    public static final String FILE_NAME = TestData.PATH + "beautifulstrings.txt";
    public static final int BUFFER_SIZE = 1024;
    public static final int ALPHABET_SIZE = 26;

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        FileInputStream buffer = new FileInputStream(file);
        byte[] input = new byte[BUFFER_SIZE];
        int inputLength;

        StringBuilder result = new StringBuilder();
        Letter[] frequence = new Letter[ALPHABET_SIZE];
        int sum = 0;

        for (int i = 0; i < ALPHABET_SIZE; i++) {
            frequence[i] = new Letter(i, 0);
        }
        while ((inputLength = buffer.read(input)) != -1) {
            if (inputLength < BUFFER_SIZE && input[inputLength - 1] != '\n') {
                input[inputLength++] = '\n';
            }
            for (int i = 0; i < inputLength; i++) {
                if (input[i] >= 'a' && input[i] <= 'z') {
                    input[i] -= 0x20;
                }
                if (input[i] >= 'A' && input[i] <= 'Z') {
                    frequence[input[i] - 0x41].inc();
                }
                if (input[i] == '\n') {
                    Arrays.sort(frequence);
                    for (int letter = 0; letter < ALPHABET_SIZE; letter++) {
                        sum += frequence[letter].getValue() * (ALPHABET_SIZE - letter);
                    }
                    result.append(sum).append('\n');

                    for (Letter letter : frequence) {
                        letter.setValue(0);
                    }
                    sum = 0;
                }
            }
        }
        System.out.print(result);
        buffer.close();
    }


    private static class Letter implements Comparable<Letter> {
        private char key;
        private int value;

        public Letter(int key, int value) {
            super();
            setKey(key);
            setValue(value);
        }

        public char getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = (char) (key + 0x41);
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void inc() {
            value++;
        }


        public int compareTo(@SuppressWarnings("NullableProblems") final Letter o) {
            return Integer.compare(o.getValue(), getValue());
        }


        @Override
        public int hashCode() {
            int result = (int) getKey();
            result = 31 * result + getValue();
            return result;
        }


        @Override
        public boolean equals(Object o) {
            return this == o
                    || !(o == null || getClass() != o.getClass())
                    && getKey() == ((Letter) o).getKey()
                    && getValue() == ((Letter) o).getValue();
        }


        @Override
        public String toString() {
            return String.format("%c = %d", getKey(), getValue());
        }
    }
}