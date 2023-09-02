import com.cj.utils.ListNode;

public class mergeKLists {
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
        ListNode[] lists = new ListNode[]{new ListNode()};
        ListNode ans = new ListNode();
        ListNode ans_head = new ListNode();
        ans_head = ans;
        while (true) {
            int i = 0;
            for (; i < lists.length; i++) {
                if (lists[i] != null)
                    break;
            }
            if (i < lists.length) {
                ans.next = sort(lists, 0, -1);
                ans = ans.next;
            }
            else {
                break;
            }
        }
        ans_head = ans_head.next;
        while (ans_head != null) {
            System.out.println(ans_head.val);
            ans_head = ans_head.next;
        }
    }

    public static ListNode sort(ListNode[] listNodes, int index, int minimum_index) {
        if (index == listNodes.length){
            ListNode listNode = new ListNode();
            listNode=listNodes[minimum_index];
            listNodes[minimum_index]=listNodes[minimum_index].next;
            return listNode;
        }
        else if (listNodes[index]==null){
            return sort(listNodes, index + 1, minimum_index);
        }
        else if (minimum_index == -1 || listNodes[minimum_index].val > listNodes[index].val){
            minimum_index = index;
        }
        return  sort(listNodes, index + 1, minimum_index);
    }
}
