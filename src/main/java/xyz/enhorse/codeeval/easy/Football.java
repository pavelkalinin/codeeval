package xyz.enhorse.codeeval.easy;

import xyz.enhorse.codeeval.TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://www.codeeval.com/open_challenges/230/
 */

public class Football {
    private static final String FILE_NAME =  TestData.path + "football.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(args.length > 0 ? args[0] : FILE_NAME);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder result = new StringBuilder();
        Map<Integer, String> teams = new TreeMap<>();
        while ((line = buffer.readLine()) != null) {
            String[] countries = line.split(" \\| ");
            for (int country = 1; country <= countries.length; country++) {
                String[] countryTeams = countries[country - 1].split(" ");
                for (String countryTeam : countryTeams) {
                    int currentTeam = Integer.parseInt(countryTeam);
                    if (teams.containsKey(currentTeam)) {
                        teams.put(currentTeam, teams.get(currentTeam) + ',' + country);
                    } else {
                        teams.put(currentTeam, ":" + country);
                    }
                }
            }
            for (Map.Entry<Integer, String> team : teams.entrySet()) {
                result.append(team.getKey()).append(team.getValue()).append("; ");
            }
            result.setLength(result.length() - 1);
            result.append('\n');
            teams.clear();
        }
        buffer.close();
        result.setLength(result.length() - 1);
        System.out.print(result);
    }
}
