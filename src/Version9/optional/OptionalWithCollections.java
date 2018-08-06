package Version9.optional;

import java.util.*;

public class OptionalWithCollections {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(5);
        integers.add(7);
        integers.add(8);
        integers.add(9);
        integers.add(0);
        integers.add(1);
        integers.add(3);

        System.out.println(max(integers));
        max(integers).ifPresent(System.out::println);
        System.out.println(maxSteam(integers));
        System.out.println(maxInt(integers));
    }

    public static <E extends Comparable<E>> Optional<E> max(Collection<E> c) {
        if (c.isEmpty())
            return Optional.empty();
        E result = null;
        for (E e : c)
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);
        return Optional.of(result);
    }

    // Returns max val in collection as Optional<E> - uses stream
    public static <E extends Comparable<E>> Optional<E> maxSteam(Collection<E> c) {
        return c.stream().max(Comparator.naturalOrder());
    }

    public static OptionalInt maxInt(Collection<Integer> c) {
        if (c.isEmpty())
            return OptionalInt.empty();
        Integer result = null;
        for (Integer e : c)
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);
        return OptionalInt.of(result);
    }
}
