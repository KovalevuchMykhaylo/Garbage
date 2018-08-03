package Version9.LabdasAndStreams;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

// Prints all large anagram groups in a dictionary iteratively
public class Anagrams {
    public static void main(String[] args) throws IOException {
        "Hello world!".chars().forEach(x -> System.out.print((char) x));
        System.out.println();
        Path dictionary = Paths.get( "/home/kovalevych/Untitled Document");
        int minGroupSize = 5;
        try (Stream<String> words = Files.lines(dictionary)) {
            words.collect(groupingBy(Anagrams::alphabetize))
                    .values().stream()
                    .filter(group -> group.size() >= minGroupSize)
                    .forEach(g -> System.out.println(g.size() + ": " + g));
        }

    }
    private static String alphabetize(String s) {
        char[] a = s.trim().toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
