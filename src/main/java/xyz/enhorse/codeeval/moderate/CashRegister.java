package xyz.enhorse.codeeval.moderate;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/54/
 */
public class CashRegister {
    private static final String FILE_NAME = TestData.path + "CashRegister.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        StringBuilder current = new StringBuilder();
        int pp, ch, rd;
        int sepPosition;
        while ((line = buffer.readLine()) != null) {
            sepPosition = line.lastIndexOf(";");
            pp = (int) (Double.parseDouble(line.substring(0, sepPosition)) * 100);
            ch = (int) (Double.parseDouble(line.substring(sepPosition + 1)) * 100);
            rd = ch - pp;
            if (rd > 0) {
                for (Cash c : Cash.values()) {
                    int amount =  rd / c.getValue();
                    if (amount > 0) {
                        for (int i = 0; i < amount; i++) {
                            current.append(c.getName());
                            rd -= c.getValue();
                        }
                    }
                    if (rd == 0) {
                        break;
                    }
                }
                current.deleteCharAt(current.length() - 1);
            } else if (rd == 0) {
                current.append("ZERO");
            } else {
                current.append("ERROR");
            }
            result.append(current).append('\n');
            current.setLength(0);
        }
        System.out.print(result);
        buffer.close();
    }

    enum Cash {
        HUNDRED("ONE HUNDRED,", 10000),
        FIFTY("FIFTY,", 5000),
        TWENTY("TWENTY,", 2000),
        TEN("TEN,", 1000),
        FIVE("FIVE,", 500),
        TWO("TWO,", 200),
        ONE("ONE,", 100),
        HALF("HALF DOLLAR,", 50),
        QUARTER("QUARTER,", 25),
        DIME("DIME,", 10),
        NICKEL("NICKEL,", 5),
        PENNY("PENNY,", 1);

        private String name;
        private int value;

        Cash(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }
    }
}
