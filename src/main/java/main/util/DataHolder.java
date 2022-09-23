package main.util;

import java.util.HashMap;

public class DataHolder {

  private final static DataHolder instance = new DataHolder();
  private final static HashMap<String, Object> container = new HashMap<>();

  private DataHolder() {

  }

  public static DataHolder getInstance() {
    return instance;
  }

  public void put(String key, Object value) {
    container.put(key, value);
  }

  public Object get(String key) {
    return container.get(key);
  }
}
