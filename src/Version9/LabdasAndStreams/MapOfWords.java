package Version9.LabdasAndStreams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class MapOfWords {

    public static void main(String[] args) {
        File file = new File("/home/kovalevych/Untitled Document 2");
        Map<String, Long> freq = new HashMap<>();
        try (Stream<String> words = new Scanner(file).tokens()) {
            freq = words
                    .collect(groupingBy(String::toLowerCase, counting()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        freq.forEach((k, v) -> System.out.println("Word : " + k + " - " + " Count : " + v));

        //Most popular lambda
        final long[] count = {0};
        final String[] mostPopularWord = {""};
        freq.forEach((k, v) -> {
            if (count[0] < v) {
                mostPopularWord[0] = k;
                count[0] = v;
            }
        });
        System.out.println("Most popular word is: " + mostPopularWord[0] + " - " + " Count : " + count[0]);

        //Most popular for
        long countF = 0;
        String mostPopularWordF = "";
        for (Map.Entry<String, Long> entry : freq.entrySet()) {
            if (countF < entry.getValue()) {
                mostPopularWordF = entry.getKey();
                countF = entry.getValue();
            }
        }
        System.out.println("Most popular word is: " + mostPopularWordF + " - " + " Count : " + countF);
    }
}
