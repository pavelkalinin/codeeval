package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.*;

/**
 * @author <a href="mailto:pavel13kalinin@gmail.com">Pavel Kalinin</a>
 *         11.07.2016
 */
public class NotSoClever {

    private static final String FILE_NAME = TestData.PATH + "NotSoClever.txt";
    private static final int BUFFER_SIZE = 1024;


    public static void main(String[] args) throws IOException {
        File inputFile = new File(args.length > 0 ? args[0] : FILE_NAME);
        FileInputStream buffer = new FileInputStream(inputFile);
        for (String input : inputStreamToSting(buffer)) {
            TaskData data = new TaskData(input);
            StupidSort solver = new StupidSort(data.array());
            System.out.println(intsToString(solver.iterate(data.number())));
        }
    }


    private static String[] inputStreamToSting(final InputStream in) throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[BUFFER_SIZE];
        int length;
        while ((length = in.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        return result.toString("UTF-8").split("\\r?\\n");
    }


    private static String intsToString(final int[] array) {
        StringBuilder result = new StringBuilder();

        for (int i : array) {
            result.append(i).append(' ');
        }

        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }


    private static class TaskData {

        private static final char PARTS_SEPARATOR = '|';
        private static final String NUMBERS_SEPARATOR = " ";

        private final int[] array;
        private final int number;


        TaskData(final String data) {
            array = extractArray(data);
            number = extractNumber(data);
        }


        int[] array() {
            return array;
        }


        int number() {
            return number;
        }


        private int extractNumber(final String data) {
            int separator = data.indexOf(PARTS_SEPARATOR);
            int result = 0;

            if ((separator > 0) && (separator < data.length() - 1)) {
                result = Integer.valueOf(data.substring(separator + 1).trim());
            }

            return result;
        }


        private int[] extractArray(final String data) {
            int separator = data.indexOf(PARTS_SEPARATOR);
            int[] result;

            if (separator > 0) {
                String array = data.substring(0, separator).trim();
                result = stringsToInts(array.split(NUMBERS_SEPARATOR));
            } else {
                result = new int[0];
            }
            return result;
        }


        private int[] stringsToInts(final String[] strings) {
            int[] result = new int[strings.length];

            for (int i = 0; i < result.length; i++) {
                result[i] = Integer.valueOf(strings[i]);
            }

            return result;
        }
    }


    private static class StupidSort {

        private final int[] array;


        StupidSort(int[] array) {
            this.array = array;
        }


        int[] iterate(int number) {
            int current = -1;

            while ((number > 0) && (current < array.length)) {
                if (swap(++current)) {
                    current = -1;
                    number--;
                }
            }

            return array;
        }


        private boolean swap(int index) {
            int next = index + 1;
            boolean swapped = false;

            if ((next < array.length) && array[index] > array[next]) {
                int tmp = array[index];
                array[index] = array[next];
                array[next] = tmp;
                swapped = true;
            }

            return swapped;
        }
    }
}
