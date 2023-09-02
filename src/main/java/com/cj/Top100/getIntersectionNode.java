import com.cj.utils.ListNode;

import java.util.HashSet;

/**
 * 得到交叉节点
 *
 * @author CJ_CA
 * @date 2023/08/22
 */
public class getIntersectionNode {
    static ListNode headA=new ListNode(1);
    static ListNode headB=new ListNode(3);
    static ListNode two=new ListNode(2);
    static {
        headA.next=two;
        headB.next=two;
        two.next=new ListNode(4);
    }


    public static void main(String[] args) {
        HashSet<ListNode> set = new HashSet<>();
        while (headA!=null){
            set.add(headA);
            headA=headA.next;
        }

        while (headB!=null){
            if(set.contains(headB)){
                System.out.println(headB.val);
                break;
            }
            headB=headB.next;
        }
        System.out.println("null");
    }
}
