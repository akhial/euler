package net.projecteuler.problems;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class _22_AlphabeticalSortHash {

    public static void main(String[] args) throws IOException {
        List<Integer> values = Files.lines(Paths.get("C:\\Users\\Adel\\Desktop\\Names.txt"))
                .map(line -> line.replaceAll("\"", ""))
                .map(line -> line.replaceAll(",", " "))
                .flatMap(line -> Pattern.compile("\\s+").splitAsStream(line))
                .sorted()
                .map(s -> s.chars().map(c -> c - 64).sum())
                .collect(Collectors.toList());
        for(int i = 0; i < values.size(); i++)
            values.set(i, values.get(i)*(i+1));
        System.out.println(values.stream().reduce(0, (x, y) -> x+y));
    }
}
