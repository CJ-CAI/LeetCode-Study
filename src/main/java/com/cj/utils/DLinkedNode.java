package com.cj.utils;

/**
 * 双向链表
 *
 * @author CJ_CA
 * @date 2023/08/20
 */
public class DLinkedNode {
    public int key;
    public int value;
    public DLinkedNode prev;
    public DLinkedNode next;

    public DLinkedNode() {
    }

    public DLinkedNode(int _key, int _value) {
        key = _key;
        value = _value;
    }
    public DLinkedNode(int _value) {
        value = _value;
    }
}
