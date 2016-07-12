package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.*;

/**
 * @author <a href="mailto:pavel13kalinin@gmail.com">Pavel Kalinin</a>
 *         12.07.2016
 */
public class SimpleOrTrump {

    private static final String FILE_NAME = TestData.PATH + "SimpleOrTrump.txt";
    private static final int BUFFER_SIZE = 1024;


    public static void main(String[] args) throws IOException {
        File inputFile = new File(args.length > 0 ? args[0] : FILE_NAME);
        FileInputStream buffer = new FileInputStream(inputFile);
        StringBuilder result = new StringBuilder();

        for (String input : inputStreamToStrings(buffer)) {
            Deal deal = new Deal(input);
            result.append(cardsToString(deal.play())).append(System.lineSeparator());
        }

        printString(result.toString());
    }


    private static String cardsToString(final Card[] winner) {
        if (winner.length == 1) {
            return winner[0].toString();
        } else {
            return winner[0].toString() + ' ' + winner[1].toString();
        }
    }


    private static String[] inputStreamToStrings(final InputStream in) {
        byte[] buffer = new byte[BUFFER_SIZE];
        int length;

        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }
            out.flush();
            return out.toString("UTF-8").split("\\r?\\n");
        } catch (IOException ex) {
            return new String[0];
        }
    }


    private static void printString(final String string) {
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {
            out.write(string);
            out.flush();
        } catch (IOException ex) {
            throw new IllegalStateException("Cannot print the string \'" + string + '\'');
        }
    }


    private enum Ranks {
        TWO("2", 1),
        THREE("3", 2),
        FOUR("4", 3),
        FIVE("5", 4),
        SIX("6", 5),
        SEVEN("7", 6),
        EIGHT("8", 7),
        NINE("9", 8),
        TEN("10", 9),
        JACK("J", 10),
        QUEEN("Q", 20),
        KING("K", 30),
        ACE("A", 40);

        private final String abbr;
        private final int value;


        Ranks(String label, int weight) {
            abbr = label;
            value = weight;
        }


        int weight() {
            return value;
        }


        String label() {
            return abbr;
        }


        static Ranks get(final String card) {
            String trimmed = card.trim();
            char mark = trimmed.charAt(0);

            for (Ranks rank : values()) {
                if (rank.abbr.charAt(0) == mark) {
                    return rank;
                }
            }

            throw new IllegalArgumentException("Unknown card rank \'" + mark + '\'');
        }
    }


    private enum Suits {
        HEARTS('H'),
        SPADES('S'),
        DIAMONDS('D'),
        CLUBS('C');

        private final char abbr;


        Suits(final char suit) {
            abbr = suit;
        }


        char label() {
            return abbr;
        }


        static Suits get(final String card) {
            String trimmed = card.trim();
            char mark = trimmed.charAt(trimmed.length() - 1);

            for (Suits suit : values()) {
                if (suit.abbr == mark) {
                    return suit;
                }
            }

            throw new IllegalArgumentException("Unknown card suite \'" + mark + '\'');
        }
    }

    private static class Deal {

        private static final char TRUMP_SEPARATOR = '|';
        private static final char CARDS_SEPARATOR = ' ';

        private final Card first;
        private final Card second;
        private final Suits trump;


        Deal(final String deal) {
            String trimmed = deal.trim();
            first = extractFirstCard(trimmed);
            second = extractSecondCard(trimmed);
            trump = extractTrump(trimmed);
        }


        Card[] play() {
            int weightFirst = calculateWeight(first);
            int weightSecond = calculateWeight(second);

            if (weightFirst == weightSecond) {
                return new Card[]{first, second};
            }

            return weightFirst > weightSecond ? new Card[]{first} : new Card[]{second};
        }


        private int calculateWeight(final Card card) {
            return card.suit() == trump ? card.rank().weight() * 1000 : card.rank().weight();
        }


        private static Suits extractTrump(final String deal) {
            int separator = deal.indexOf(TRUMP_SEPARATOR);

            if (separator > 0) {
                return Suits.get(deal);
            }

            throw new IllegalStateException("Incorrect deal \'" + deal + '\'');
        }


        private static Card extractFirstCard(final String deal) {
            int separator = deal.indexOf(CARDS_SEPARATOR);

            if (separator > 0) {
                return new Card(deal.substring(0, separator));
            }

            throw new IllegalStateException("Incorrect deal \'" + deal + '\'');
        }


        private static Card extractSecondCard(final String deal) {
            int cardsSeparator = deal.indexOf(CARDS_SEPARATOR);

            if (cardsSeparator > 0) {
                int trumpSeparator = deal.indexOf(TRUMP_SEPARATOR);
                return new Card(deal.substring(cardsSeparator + 1, trumpSeparator));
            }

            throw new IllegalStateException("Incorrect deal \'" + deal + '\'');
        }
    }

    private static class Card {

        private final Ranks rank;
        private final Suits suit;


        Card(final String card) {
            rank = Ranks.get(card);
            suit = Suits.get(card);
        }


        Ranks rank() {
            return rank;
        }


        Suits suit() {
            return suit;
        }


        @Override
        public String toString() {
            return rank().label() + suit().label();
        }
    }
}
