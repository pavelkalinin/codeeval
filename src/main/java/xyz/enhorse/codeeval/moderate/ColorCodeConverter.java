package xyz.enhorse.codeeval.moderate;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/148/
 */
public class ColorCodeConverter {

    private static final String FILE_NAME = TestData.PATH + "colorcodeconverter.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            result.append(convert(line)).append('\n');
        }
        System.out.print(result);
        buffer.close();
    }

    public static String convert(String color) {
        return rgbToString(ColorSchemes.parse(color).convertToRGB());
    }

    private static String rgbToString(final double[] values) {
        return String.format("RGB(%d,%d,%d)", Math.round(values[0]), Math.round(values[1]), Math.round(values[2]));
    }

    private enum ColorSchemes {

        // 0 <= CYAN <= 1, 0 <= MAGENTA <= 1, 0 <= YELLOW <= 1, 0 <= BLACK <= 1
        CMYK("(0,0,0,0)") {
            @Override
            public double[] convertToRGB() {
                double cyan = CMYK.components[0];
                double magenta = CMYK.components[1];
                double yellow = CMYK.components[2];
                double black = CMYK.components[3];

                double red = (1 - cyan) * (1 - black) * 255;
                double green = (1 - magenta) * (1 - black) * 255;
                double blue = (1 - yellow) * (1 - black) * 255;

                return new double[]{red, green, blue};
            }
        },


        // 0 <= HUE < 360, 0 <= SATURATION <= 1, 0 <= LIGHTNESS <= 1
        HSV("HSV(0,0,0)") {
            @Override
            public double[] convertToRGB() {
                double hue = HSV.components[0];
                double saturation = HSV.components[1] / 100;
                double value = HSV.components[2] / 100;

                double c = value * saturation;
                double x = c * (1 - Math.abs((hue / 60) % 2 - 1));
                double m = value - c;

                return computeRGBFromHUE(hue, c, x, m);
            }
        },

        // 0 <= HUE < 360, 0 <= SATURATION <= 1, 0 <= LIGHTNESS <= 1
        HSL("HSL(0,0,0)") {
            @Override
            public double[] convertToRGB() {
                double hue = HSL.components[0];
                double saturation = HSL.components[1] / 100;
                double lightness = HSL.components[2] / 100;

                double c = (1 - Math.abs(2 * lightness - 1)) * saturation;
                double x = c * (1 - Math.abs((hue / 60) % 2 - 1));
                double m = lightness - c / 2;

                return computeRGBFromHUE(hue, c, x, m);
            }
        },

        //"#FFFFFF"
        HEX("#000000") {
            @Override
            public double[] convertToRGB() {
                int hex = (int) HEX.components[0];
                return new double[]{(hex & 0xFF0000) >> 16, (hex & 0xFF00) >> 8, hex & 0xFF};
            }
        };

        private double[] components;

        ColorSchemes(String value) {
            setComponents(value);
        }


        public abstract double[] convertToRGB();


        private void setComponents(String value) {
            components = parseComponents(value);
        }


        public static ColorSchemes parse(String string) {
            if (string.startsWith("HSV")) {
                HSV.setComponents(string);
                return HSV;
            }
            if (string.startsWith("HSL")) {
                HSL.setComponents(string);
                return HSL;
            }
            if (string.startsWith("#")) {
                HEX.setComponents(string);
                return HEX;
            }
            CMYK.setComponents(string);
            return CMYK;
        }


        private static double[] parseComponents(String color) {
            if (color.indexOf('#') == 0) {
                return new double[]{Integer.parseInt(color.substring(color.indexOf('#') + 1), 16)};
            }

            String[] values = color.substring(color.indexOf('(') + 1, color.lastIndexOf(')')).split(",");
            double[] components = new double[values.length];
            for (int i = 0; i < components.length; i++) {
                components[i] = Double.parseDouble(values[i]);
            }
            return components;
        }


        private static double[] computeRGBFromHUE(double hue, double c, double x, double m) {
            c = (c + m) * 255;
            x = (x + m) * 255;
            m = m * 255;
            switch ((int) (hue / 60)) {
                case 0: {
                    return new double[]{c, x, m};
                }
                case 1: {
                    return new double[]{x, c, m};
                }
                case 2: {
                    return new double[]{m, c, x};
                }
                case 3: {
                    return new double[]{m, x, c};
                }
                case 4: {
                    return new double[]{x, m, c};
                }
                default: {
                    return new double[]{c, m, x};
                }
            }
        }
    }
}
