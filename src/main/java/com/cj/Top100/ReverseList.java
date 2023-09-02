import com.cj.utils.ListNode;

/**
 * 反向列表
 *
 * @author CJ_CA
 * @date 2023/08/28
 */
public class ReverseList {
    static ListNode head = new ListNode(1);
    static ListNode two = new ListNode(2);
    static ListNode three = new ListNode(3);

    static {
        head.next = two;
        two.next = three;
        three.next = new ListNode(4);
    }

    public static void main(String[] args) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode prev = head;
        ListNode present = head = head.next;
        prev.next = null;
        while (head != null) {
            present = head;
            head = head.next;
            present.next = prev;
            prev = present;
        }
        while (present != null) {
            System.out.print(present.val+" ");
            present = present.next;
        }
    }
}
