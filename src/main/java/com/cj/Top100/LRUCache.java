import com.cj.utils.DLinkedNode;

import java.util.*;

/**
 * LRU 缓存
 *
 * @author CJ_CA
 * @date 2023/08/19
 */
public class LRUCache {
    HashMap<Integer, DLinkedNode> maps;
    DLinkedNode head, tail;

    int Capacity;

    public LRUCache(int capacity) {

        this.Capacity = capacity;
        maps = new HashMap<Integer, DLinkedNode>(capacity, 0.75F);
    }

    public int get(int key) {
        DLinkedNode node = maps.get(key);
        if (node != null) {
            deleteNode(node);
            AddToFirst(node);
            maps.put(key, node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        DLinkedNode node = new DLinkedNode(key, value);
        if (maps.containsKey(key)) {
            deleteNode(maps.get(key));
        }
        else if (maps.size() == Capacity) {
            maps.remove(deleteTailNode());
        }
        maps.put(key, node);
        AddToFirst(node);
    }

    public void deleteNode(DLinkedNode node) {
        if(maps.size()==1){
            head = tail = null;
        }
        else if (node.next == null) {
            tail = node.prev;
            tail.next=null;
        } else if (node.prev == null) {
           node=node.next;
           node.prev=null;
           head=node;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public int deleteTailNode() {

        int tail_key = tail.key;
        if (tail.prev == null) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        return tail_key;
    }

    public void AddToFirst(DLinkedNode node) {
        node.prev=node.next=null;
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev=node;
            head = node;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        /*lruCache.put(1, 0);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));*/

        lruCache.put(2, 6);
        System.out.println(lruCache.get(1));
        lruCache.put(1, 5);
        lruCache.put(1, 2);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));

    }

}
