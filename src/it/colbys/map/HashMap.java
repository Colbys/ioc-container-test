package it.colbys.map;

@SuppressWarnings({"rawtypes","unchecked"})
public class HashMap<K, V> implements IMap<K, V> {

    private int numBuckets;
    private int size;
    private transient Node<K, V>[] entries;

    private static final double LOAD_THRESHOLD = 0.7;

    private class Node<T, U> {
        final private int hash;
        final private T key;
        private U value;
        private Node<T, U> next;

        public Node(T key, U value, int hash, Node<T, U> next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }
    }

    public HashMap() {
        numBuckets = 16;
        size = 0;
        entries = new Node[numBuckets];
    }

    @Override
    public V put(Object key, Object value) {
        int keyHash = key.hashCode();
        int index = index(keyHash);
        Node node = new Node(key, value, keyHash, null);
        if (entries[index] == null) {
            entries[index] = node;
        } else {
            Node collision = entries[index];
            K keyCollision = (K) collision.key;
            if (keyCollision.equals(key) && key.hashCode() == keyCollision.hashCode()) {
                collision.value = node.value;
            } else {
                collision.next = node;
            }
        }
        size++;

        if ((1.0 * size)/numBuckets >= LOAD_THRESHOLD) {
            numBuckets *= 2;
            size = 0;
            Node<K, V>[] tempArray = entries;
            entries = new Node[numBuckets];

            for (Node<K, V> entry : tempArray) {
                while (entry != null) {
                    put(entry.key, entry.value);
                    entry = entry.next;
                }
            }
        }
        return (V) value;
    }

    @Override
    public V get(Object key) {
        int keyHash = key.hashCode();
        int index = index(keyHash);
        Node<K, V> node = entries[index];
        if (node == null) {
            return null;
        }
        if (key.equals(node.key) && keyHash == node.hash) {
            return node.value;
        }
        if (node.next != null) {
            do {
                node = node.next;
                if (key.equals(node.key) && keyHash == node.hash) {
                    return node.value;
                }
            } while (node.next != null);
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        int keyHash = key.hashCode();
        int index = index(keyHash);

        Node<K, V> head = entries[index];
        Node<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                break;
            }

            prev = head;
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        size--;
        if (prev != null) {
            prev.next = head.next;
        } else {
            entries[index] = head.next;
        }

        return head.value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private int index(int keyHash) {
        return keyHash & (numBuckets - 1);
    }
}
