package Version9.grabage;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StaticMapWithData {

    //java 9
    private static final Map<Integer, String> myMap9 = Map.of(1, "one", 2, "two");

    //java 8
    private static final Map<Integer, String> myMap8;
    static {
        Map<Integer, String> aMap = new HashMap<>();
        aMap.put(1, "one");
        aMap.put(2, "two");
        myMap8 = Collections.unmodifiableMap(aMap);
    }
}
