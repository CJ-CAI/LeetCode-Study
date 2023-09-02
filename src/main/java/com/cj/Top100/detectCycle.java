import com.cj.utils.ListNode;

/**
 * 环形链表 II
 *
 * @author CJ_CA
 * @date 2023/08/19
 */
public class detectCycle {
    static ListNode head=new ListNode(3);
    static ListNode one=new ListNode(2);
    static ListNode two=new ListNode(0);

    static ListNode three=new ListNode(-4);

    static {
        head.next=one;one.next=two;two.next=three;
        three.next=one;
    }

    public static void main(String[] args) {
        ListNode slow=head;
        ListNode fast=head;
        ListNode measure=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                while (measure!=slow){
                    measure=measure.next;
                    slow=slow.next;
                }
                System.out.println(measure.val);
                break;
            }
        }
        System.out.println("null");
    }
}
