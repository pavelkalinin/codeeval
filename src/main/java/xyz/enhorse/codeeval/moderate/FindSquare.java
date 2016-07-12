package xyz.enhorse.codeeval.moderate;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.codeeval.com/browse/101/
 */
public class FindSquare {
    private static final Pattern PATTERN = Pattern.compile("\\d");
    private static final String FILE_NAME = TestData.PATH + "FindSquare.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;

        StringBuilder result = new StringBuilder();
        Point[] points = new Point[4];
        Matcher matcher;
        int[] coordinates = new int[8];
        Set<Double> d = new HashSet<>(12);

        while ((line = buffer.readLine()) != null) {
            matcher = PATTERN.matcher(line);
            int index = 0;
            while (matcher.find()) {
                coordinates[index++] = Integer.parseInt(matcher.group());
            }
            for (int i = 0; i < points.length; i++) {
                points[i] = new Point(coordinates[i * 2], coordinates[i * 2 + 1]);
            }

            d.clear();
            for (int i = 0; i < points.length; i++) {
                for (int j = 0; j < points.length; j++) {
                    if (i != j) {
                        d.add(points[i].distance(points[j]));
                    }
                }
            }
            result.append(d.size() == 2).append('\n');
        }

        System.out.print(result);
        buffer.close();
    }

    private static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public double distance(Point pt) {
            double px = pt.getX() - this.getX();
            double py = pt.getY() - this.getY();
            return Math.sqrt(px * px + py * py);
        }
    }
}


