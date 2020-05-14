package patterns.map;

public class MapImpl<K, V> implements Map<K, V> {

    class Node<K, V> {
        K key;
        V value;
        int hash;
        Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.hash = 0;
            this.next = null;
        }
    }

    Node<K, V>[] elements;
    int size;

    public MapImpl() {
        elements = new Node[16];
        size = 16;
    }

    @Override
    public V get(K key) {
        int hash = hashCode(key);
        int bucket = hash % size;
        if(elements[bucket] != null) {

            Node head = elements[bucket];
            while(head != null && !head.key.equals(key)) {
                head = head.next;
            }

            if(head != null)
                return (V)head.value;
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        Node node = new Node(key, value);
        node.hash = hashCode(key);
        int bucket = node.hash % size;
        if(elements[bucket] != null) {
            Node head = elements[bucket];
            while(head.next != null && !head.key.equals(key)) {
                head = head.next;
            }
            if(head == null) {
                head.next = node;
            } else {
                head.value = value;
            }
        } else {
            elements[bucket] = node;
        }
    }

    int hashCode(K key) {
        return key.hashCode();
    }
}
