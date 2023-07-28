import utils.ListNode;

public class removeNthFromEnd {

    public static ListNode head = new ListNode();
    static int n = 5;

    static {
        ListNode prev = new ListNode(1, null);
        head = prev;
        for (int i = 2; i < 11; i++) {
            prev.next = new ListNode(i, null);
            prev=prev.next;
        }
    }


    public static void main(String[] args) {
        ListNode start=new ListNode();
        start.next=head;
        int length = getLength(head);
        if (length == n)
            start.next = head.next;
        else {
            while (length - n - 1 > 0) {
                head = head.next;
                length--;
            }
            head.next = head.next.next;
        }
        for (ListNode tamp = start.next; tamp != null; tamp = tamp.next) {
            System.out.print(tamp.val + " ");
        }
//        System.out.println(head.val);
    }

    public static int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }
}
