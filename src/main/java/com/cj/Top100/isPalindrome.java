/**
 * @author CJ_CA
 * @date 2023/09/01
 */
import com.cj.utils.ListNode;

public class isPalindrome {
    static ListNode head=new ListNode(1);
    static ListNode two=new ListNode(0);
    static ListNode three=new ListNode(2);
    static ListNode four=new ListNode(0);
    static ListNode five=new ListNode(1);
    static {
        head.next=two;
//        two.next=three;
//        three.next=four;
//        four.next=five;
    }


    public static void main(String[] args) {
        if(head.next==null) {
            return;
        }
        //快慢锁定mid时同时反转前半部分
        ListNode pre,slow,fast,after;
        pre=slow=fast=head;
        after=head.next;

        while (fast.next!=null&&fast.next.next!=null){
            slow=after;
            fast=fast.next.next;
            ListNode Temp=after.next;
            after.next=pre;
            pre=after;
            after=Temp;
        }
        head.next=null;
        if(fast.next==null&&fast!=head){
            slow=slow.next;
        }

        while (slow!=null){
            if(after.val!=slow.val){
                System.out.println(false);
                return;
            }
            after=after.next;
            slow=slow.next;
        }

    }
}
