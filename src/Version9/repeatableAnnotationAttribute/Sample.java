package Version9.repeatableAnnotationAttribute;

import java.util.ArrayList;
import java.util.List;

public class Sample {

    // Code containing a repeated annotation
    @ExceptionTest(IndexOutOfBoundsException.class)
    @ExceptionTest(NullPointerException.class)
    public static void doublyBad() {

        List<String> list = new ArrayList<>();
// The spec permits this method to throw either
// IndexOutOfBoundsException or NullPointerException
        list.addAll(5, null);

        list.forEach(System.out::println);
    }
}
