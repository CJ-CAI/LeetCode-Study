package com.cj.Top100;

import com.cj.utils.ListNode;

import java.util.HashSet;

/**
 * 环形链表
 *
 * @author CJ_CA
 * @date 2023/08/18
 */
public class hasCycle {
    static ListNode head=new ListNode(3);
    static ListNode one=new ListNode(2);
    static ListNode two=new ListNode(0);

    static ListNode three=new ListNode(-4);

    static {
        head.next=one;one.next=two;two.next=three;
//        three.next=one;
    }

    public static void main(String[] args) {
        HashSet<ListNode> set = new HashSet<>();
        while (head!=null){
            if(set.contains(head)){
                System.out.println(true);
                break;
            }else {
                set.add(head);
                head=head.next;
            }
        }
        System.out.println(false);
    }
}
