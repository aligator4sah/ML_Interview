package com.class21;

import java.util.HashMap;
import java.util.Map;

public class DeepCopyLinkedListRandom {
    // Method 1: using Hashmap to avoid duplication for the same node
    public RandomListNode copy(RandomListNode head) {
        if (head == null) {
            return head;
        }

        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = dummy;

        // maintain a hashmap to record the original node with its copied node
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (head != null) {
            // copy the current node if it's not in the map
            if (!map.containsKey(head)) {
                map.put(head, new RandomListNode(head.val));
            }
            // Connect the copied node to the deep copy list
            cur.next = map.get(head);
            // copy the random node if it's not in the map
            if (head.random != null) {
                if (!map.containsKey(head.random)) {
                    map.put(head.random, new RandomListNode(head.random.val));
                }
                cur.next.random = map.get(head.random);
            }
            head = head.next;
            cur = cur.next;
        }
        return dummy.next;   
    }


    // Method 2: 3 pass solution
    public RandomListNode copyII(RandomListNode head) {
        if (head == null) {
            return head;
        }

        // 1st pass, for each node in the original list, insert a copied node between the node and node.next
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode copy = new RandomListNode(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = cur.next.next;
        }

        // 2nd pass, link the random pointer for the copied node
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        
        //3rd pass, extract the copied node
        cur = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode copyPrev = dummy;
        while (cur != null) {
            copyPrev.next = cur.next;
            cur.next = cur.next.next;
            copyPrev = copyPrev.next;
            cur = cur.next;
        }
        return dummy.next;
    }

    static class RandomListNode {
        int val;
        RandomListNode next;
        RandomListNode random;

        RandomListNode(int value) {
            this.val = value;
        }
    }
    
}
