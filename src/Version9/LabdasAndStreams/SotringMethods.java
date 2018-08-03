package Version9.LabdasAndStreams;

import java.util.Comparator;
import java.util.List;

public class SotringMethods {

    public void sortStringByLenght(List<String> words) {
        words.sort(Comparator.comparingInt(String::length));
    }
}
