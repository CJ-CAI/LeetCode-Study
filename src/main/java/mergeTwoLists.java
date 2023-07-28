import utils.ListNode;

public class mergeTwoLists {
    public static ListNode list1 = new ListNode();
    public static ListNode list2 = new ListNode();

    static {
        ListNode prev = new ListNode(1, null);
        list1 = prev;
        for (int i = 2; i < 5; i++) {
            prev.next = new ListNode(i, null);
            prev = prev.next;
        }
    }

    static {
        ListNode prev = new ListNode(1, null);
        list2 = prev;
        for (int i = 6; i < 8; i++) {
            prev.next = new ListNode(i, null);
            prev = prev.next;
        }
    }

    public static void main(String[] args) {
        ListNode list3 = getListNode();
        ListNode head;
        head = list3;
        while (list1 != null || list2 != null) {
            if(list1==null){
                list3.next = list2;
                break;
            }
            else if (list2==null) {
                list3.next = list1;
                break;
            }
            else if (list1.val <= list2.val) {
                list3.next = list1;
                list1 = list1.next;
            } else{
                list3.next = list2;
                list2=list2.next;
            }
            list3=list3.next;
        }
        head=head.next;
        while (head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
    }

    private static ListNode getListNode() {
        ListNode list3 = new ListNode(0,null);
        ListNode head = new ListNode();
        return list3;
    }
}

