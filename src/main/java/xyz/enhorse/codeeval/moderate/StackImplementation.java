package xyz.enhorse.codeeval.moderate;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

/**
 * https://www.codeeval.com/open_challenges/9/
 */
public class StackImplementation {
    private static final String FILE_NAME = TestData.path + "stackimplementation.txt";

    public static void main (String[] args) throws IOException  {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder output = new StringBuilder();
        StringBuilder result = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            String[] numbers = line.trim().split(" ");
            Stack<Integer> stack = new Stack<>();
            for (String number : numbers) {
                stack.push(Integer.valueOf(number));
            }
            boolean print = true;
            while (!stack.isEmpty()) {
                int i = stack.pop();
                if (print) {
                    output.append(i);
                    if (stack.size() >= 2) {
                        output.append(" ");
                    }
                }
                print = !print;
            }
            result.append(output).append('\n');
            output.setLength(0);
        }
        System.out.print(result);
    }
}