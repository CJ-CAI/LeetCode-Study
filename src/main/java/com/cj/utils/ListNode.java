package com.cj.utils;

/**
 * 列表节点
 *
 * @author CJ_CA
 * @date 2023/08/21
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}