package solutions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * <p>Used the Java API to replace each name with it's code. The relevant code here is
 * {@code s -> s.chars().map(c -> c - 64).sum()}.</p>
 */

public class _022 {

    public static int namesScores() throws IOException {
        List<Integer> values = Files.lines(Paths.get("res/p022_names.txt"))
                .map(line -> line.replaceAll("\"", ""))
                .map(line -> line.replaceAll(",", " "))
                .flatMap(line -> Pattern.compile("\\s+").splitAsStream(line))
                .sorted()
                .map(s -> s.chars().map(c -> c - 64).sum())
                .collect(Collectors.toList());
        for(int i = 0; i < values.size(); i++)
            values.set(i, values.get(i)*(i + 1));
        return values.stream().reduce(0, Integer::sum);
    }
}
