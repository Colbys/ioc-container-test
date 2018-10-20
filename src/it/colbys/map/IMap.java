package it.colbys.map;

public interface IMap<K, V> {

    V put(K key, V value);

    V get(K key);

    V remove(K key);

    int getSize();

    boolean isEmpty();
}
