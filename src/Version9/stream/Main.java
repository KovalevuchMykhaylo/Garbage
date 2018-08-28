package Version9.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        System.out.println(numbers.stream().collect(Collectors.partitioningBy((p) -> p%2 == 0)));

        System.out.println(numbers.stream().collect(Collectors.summarizingInt((p) -> p)));
    }
}
