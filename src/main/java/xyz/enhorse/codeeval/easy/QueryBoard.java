package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/87/
 */

public class QueryBoard {

    private static final String FILE_NAME = TestData.PATH + "queryboard.txt";
    private static final int BUFFER_SIZE = 1024;
    private static final Board board = new Board(256, 256);

    public static void main(String[] args) throws IOException {
        File inputFile = new File(args.length > 0 ? args[0] : FILE_NAME);
        FileInputStream buffer = new FileInputStream(inputFile);
        byte[] input = new byte[BUFFER_SIZE];
        int inputLength;
        StringBuilder result = new StringBuilder();
        StringBuilder current = new StringBuilder();
        StringBuilder command = new StringBuilder();
        Command cmd;
        int[] arguments = {-1, -1};
        while ((inputLength = buffer.read(input)) != -1) {
            if (inputLength < BUFFER_SIZE && input[inputLength - 1] != '\n') {
                input[inputLength++] = '\n';
            }
            for (int i = 0; i < inputLength; i++) {
                switch (input[i]) {
                    case '\r': {
                        continue;
                    }
                    case ' ':
                    case '\n': {
                        if (command.length() == 0) {
                            command.append(current);
                        } else {
                            if (arguments[0] == -1) {
                                arguments[0] = Integer.parseInt(current.toString());
                            } else {
                                arguments[1] = Integer.parseInt(current.toString());
                            }
                        }
                        if (input[i] == '\n') {
                            cmd = Command.get(command.toString());
                            if (cmd == Command.QUERY_COL || cmd == Command.QUERY_ROW) {
                                result.append(execute(cmd, arguments)).append('\n');
                            } else {
                                execute(cmd, arguments);
                            }
                            command.setLength(0);
                            arguments[0] = -1;
                            arguments[1] = -1;
                        }
                        current.setLength(0);
                        break;
                    }
                    default: {
                        current.append((char) input[i]);
                    }
                }
            }
        }
        System.out.print(result);
        buffer.close();
    }

    private static int execute(Command command, int[] args) {
        switch (command) {
            case SET_COL: {
                board.setCol(args[0], args[1]);
                break;
            }
            case SET_ROW: {
                board.setRow(args[0], args[1]);
                break;
            }
            case QUERY_COL: {
                return board.getColSum(args[0]);
            }
            case QUERY_ROW: {
                return board.getRowSum(args[0]);
            }
            default: {
                throw new IllegalArgumentException("Command Unknown!");
            }
        }
        return 0;
    }


    private enum Command {
        SET_COL,
        SET_ROW,
        QUERY_COL,
        QUERY_ROW;

        public static Command get(final String command) {
            switch (command) {
                case "SetCol": {
                    return SET_COL;
                }
                case "SetRow": {
                    return SET_ROW;
                }
                case "QueryCol": {
                    return QUERY_COL;
                }
                case "QueryRow": {
                    return QUERY_ROW;
                }
                default: {
                    throw new IllegalArgumentException("Command Unknown!");
                }
            }
        }
    }

    private static class Board {
        int width, height;
        private int[][] board;

        public Board(int width, int height) {
            super();
            this.height = height;
            this.width = width;
            this.board = new int[height][width];
        }

        public void setCol(int col, int value) {
            for (int i = 0; i < width; i++) {
                this.board[i][col] = value;
            }
        }

        public void setRow(int row, int value) {
            for (int i = 0; i < height; i++) {
                this.board[row][i] = value;
            }
        }

        public int getColSum(int col) {
            int result = 0;
            for (int i = 0; i < width; i++) {
                result += this.board[i][col];
            }
            return result;
        }

        public int getRowSum(int row) {
            int result = 0;
            for (int i = 0; i < height; i++) {
                result += this.board[row][i];
            }
            return result;
        }

        public void print() {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    System.out.printf("%3d", board[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }


    }
}