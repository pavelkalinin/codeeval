package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/163/
 */

public class BigDigits {

    private static final String FILE_NAME = TestData.PATH + "bigdigits.txt";
    private static final String STRIPE = "-----";
    private static final int BUFFER_SIZE = 1024;
    private static final String[][] DIGITS = {
                    {
                            "-**--",
                            "*--*-",
                            "*--*-",
                            "*--*-",
                            "-**--"},

                    {
                            "--*--",
                            "-**--",
                            "--*--",
                            "--*--",
                            "-***-"},
                    {
                            "***--",
                            "---*-",
                            "-**--",
                            "*----",
                            "****-"},
                    {
                            "***--",
                            "---*-",
                            "-**--",
                            "---*-",
                            "***--"},
                    {
                            "-*---",
                            "*--*-",
                            "****-",
                            "---*-",
                            "---*-"},
                    {
                            "****-",
                            "*----",
                            "***--",
                            "---*-",
                            "***--"},
                    {
                            "-**--",
                            "*----",
                            "***--",
                            "*--*-",
                            "-**--"},
                    {
                            "****-",
                            "---*-",
                            "--*--",
                            "-*---",
                            "-*---"},
                    {
                            "-**--",
                            "*--*-",
                            "-**--",
                            "*--*-",
                            "-**--"},

                    {
                            "-**--",
                            "*--*-",
                            "-***-",
                            "---*-",
                            "-**--"}};
    private static final StringBuilder RESULT = new StringBuilder();

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        FileInputStream buffer = new FileInputStream(file);
        byte[] digits = new byte[16];
        byte numberOfDigits = 0;
        byte[] input = new byte[BUFFER_SIZE];
        int inputLength;
        while ((inputLength = buffer.read(input)) != -1) {
            if (inputLength < BUFFER_SIZE && input[inputLength - 1] != '\n') {
                input[inputLength++] = '\n';
            }
            for (int i = 0; i < inputLength; i++) {
                if (input[i] == '\n') {
                    getScreening(digits, numberOfDigits);
                    numberOfDigits = 0;
                }
                if (input[i] >= '0' && input[i] <= '9') {
                    digits[numberOfDigits++] = (byte) (input[i] - 0x30);
                }
            }
        }
        System.out.print(RESULT);
        buffer.close();
    }

    private static void getScreening(byte[] digits, int numberOfDigits) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < numberOfDigits; j++) {
                RESULT.append(DIGITS[digits[j]][i]);
            }
            RESULT.append('\n');
        }
        for (int i = 0; i < numberOfDigits; i++) {
            RESULT.append(STRIPE);
        }
        RESULT.append('\n');
    }
}
