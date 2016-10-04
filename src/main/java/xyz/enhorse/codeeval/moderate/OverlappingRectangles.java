package xyz.enhorse.codeeval.moderate;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author <a href="mailto:pavel13kalinin@gmail.com">Pavel Kalinin</a>
 *         04.10.2016
 */
public class OverlappingRectangles {

    private static final String FILE_NAME = TestData.PATH + "overlapping_rectangles.txt";


    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        RectanglesPair pair;

        while ((line = buffer.readLine()) != null) {
            pair = new RectanglesPair(line);
            result.append(pair.isOverLapping() ? "True" : "False").append('\n');
        }

        System.out.print(result);
        buffer.close();
    }


    private static class RectanglesPair {
        private final Rectangle a;
        private final Rectangle b;


        RectanglesPair(final String string) {
            int[] points = new int[8];
            int i = 0;

            for (String point : string.split(",")) {
                points[i++] = Integer.parseInt(point);
            }

            a = new Rectangle(new Point(points[0], points[1]), new Point(points[2], points[3]));
            b = new Rectangle(new Point(points[4], points[5]), new Point(points[6], points[7]));
        }


        boolean isOverLapping() {
            return !(a.topLeft.x > b.bottomRight.x
                    || a.bottomRight.x < b.topLeft.x
                    || a.topLeft.y < b.bottomRight.y
                    || a.bottomRight.y > b.topLeft.y);
        }
    }


    private static class Point {

        final int x;
        final int y;


        Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }


    private static class Rectangle {

        private final Point topLeft;
        private final Point bottomRight;


        Rectangle(final Point topLeft, final Point bottomRight) {
            this.topLeft = topLeft;
            this.bottomRight = bottomRight;
        }
    }
}
