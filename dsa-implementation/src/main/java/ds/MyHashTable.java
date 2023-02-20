package ds;

import java.lang.reflect.Array;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BiPredicate;

import static java.util.Objects.hash;

public class MyHashTable {

    private final List<KeyValuePair>[] data;

    public MyHashTable(int size) {
        this.data = (List<KeyValuePair>[]) Array.newInstance(ArrayList.class,
                5);
    }

    public void set(String key, String value) {
        int hash = Math.floorMod( hash(key),  data.length);
        if (data[hash] == null) {
            data[hash] = new ArrayList<>();
        }
        data[hash].add(new KeyValuePair(key, value));
    }

    public String get(String key) {
        int hash = Math.floorMod( hash(key),  data.length);
        List<KeyValuePair> keyValuePairList = data[hash];
        for ( KeyValuePair keyValuePair :
             keyValuePairList) {
            if (keyValuePair.getKey().equals(key))
                return keyValuePair.getValue();
        }
        return null;
    }

    public List<String> keys() {
        List<String> keys = new ArrayList<>();
        for (List<KeyValuePair> datum : data) {
            if (datum == null) {
                continue;
            }
            datum.forEach(keyValuePair -> keys.add(keyValuePair.getKey()));
        }
        return keys;
    }

    public void printHashTable() {
        for (int i = 0; i < data.length; i++) {
            int hash = i;
            List<KeyValuePair> datum = data[i];
            if (datum == null)
                continue;
            datum.forEach(keyValuePair -> {
                System.out.printf("bucket = %d, key = %s, value = %s\n",
                        hash,
                        keyValuePair.getKey(), keyValuePair.getValue());
            });
        }
    }

    private class KeyValuePair {
        String Key;
        String Value;


        public KeyValuePair(String key, String value) {
            Key = key;
            Value = value;
        }

        public String getKey() {
            return Key;
        }

        public String getValue() {
            return Value;
        }
    }
}
