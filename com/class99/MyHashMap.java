package com.class99;

public class MyHashMap<K, V> {
    Node[] table;
    int size;

    MyHashMap() {
        table = new Node[16];
    }

    public void put(K key, V value) {
        Node newNode = new Node<>();
        newNode.hash = MyHashCode(key.hashCode(), table.length);
        newNode.key = key;
        newNode.value = value;

        Node temp = table[newNode.hash];
        Node lastElement = null;
        boolean repeatKey = false;

        if (temp == null) {
            // put the node in directly
            table[newNode.hash] = newNode;
            size++;
        }

        while (temp != null) {
            if (temp.key.equals(key)) {
                repeatKey = true;
                temp.value = value;
                break;
            } else {
                lastElement = temp;
                temp = temp.next;
            }
        }
        if (!repeatKey) {
            lastElement.next = newNode;
            size++;
        }
        // todo: add reize and rehash code
    }

    public int MyHashCode(int v, int length) {
        System.out.println("hash value by &" + (v & (length - 1)));
        System.out.println("hash value by %" + (v % (length - 1)));
        return v & (length - 1);
    }

    public V get(K key) {
        int hash = MyHashCode(key.hashCode(), table.length);
        V value = null;
        if (table[hash] != null) {
            Node temp = table[hash];
            while (temp != null) {
                if (temp.key.equals(key)) {
                    value = (V) temp.value;
                    break;
                } else {
                    temp = temp.next;
                }
            }
        }
        return value;
    }

    public V remove(K key) {
        int hashIndex = MyHashCode(key.hashCode(), table.length);
        Node temp = table[hashIndex];
        Node pre = null;
        while (temp != null && temp.key != key) {
            pre = temp;
            temp = temp.next;
        }
        if (temp != null && pre != null) {
            pre.next = temp.next;
        } else if (temp != null) {
            this.table[hashIndex] = temp.next;
        }
        return (V) temp.value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < table.length; i++) {
            Node temp = table[i];
            while (temp != null) {
                sb.append(temp.key + ":" + temp.value + ",");
                temp = temp.next;
            }
        }
        sb.setCharAt(sb.length() - 1, '}');
        return sb.toString();
    }

    public static void main(String[] args) {
        MyHashMap<Integer, String> m = new MyHashMap<>();
        m.put(10, "aa");
        m.put(20, "bb");
        m.put(30, "cc");
        m.put(30, "a");
        System.out.println(m);
        System.out.println(m.get(30));
    }
}
