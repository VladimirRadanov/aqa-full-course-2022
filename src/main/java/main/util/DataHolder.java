package main.util;

import org.apache.commons.collections4.map.MultiKeyMap;
import org.junit.jupiter.api.Assertions;

public class DataHolder {

    private final static DataHolder instance = new DataHolder();
    private final static MultiKeyMap multiKeyContainer = new MultiKeyMap();

    private DataHolder() {

    }

    public static DataHolder getInstance() {
        return instance;
    }


    public void put(String key, Object value) {
        if (multiKeyContainer.containsKey(key, value.getClass())) {
            Assertions.fail("This key is already in use!");
        }
        multiKeyContainer.put(key, value.getClass(), value);
    }

    public void putOrUpdateValue(String key, Object value) {
        multiKeyContainer.put(key, value.getClass(), value);
    }

    public <T> T get(String key, Class<T> type) {
        T result = (T) multiKeyContainer.get(key, type);
        Assertions.assertNotNull(result, String.format("Value for key %s and type %s is empty!", key, type.getSimpleName()));
        return result;
    }
}
