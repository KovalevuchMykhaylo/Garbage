package Version9.LabdasAndStreams;

import java.util.Map;

public class IncrementIfinMap {

    public void incrementValueIfKeyPresent(Map<String, Integer> stringIntegerMap, String key) {
        stringIntegerMap.merge(key, 1, Integer::sum);
    }
}
