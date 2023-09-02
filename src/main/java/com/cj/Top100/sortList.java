import com.cj.utils.ListNode;

/**
 * 列表归并排序
 *
 * @author CJ_CA
 * @date 2023/08/21
 */
public class sortList {
    static ListNode head=new ListNode(3);
    static ListNode two=new ListNode(2);
    static ListNode three=new ListNode(-15);
    static ListNode four=new ListNode(100);

    static {
        head.next=two;
        two.next=three;
        three.next=four;
    }

    public ListNode getMid(ListNode head) {
        ListNode first=head;
        ListNode second=head.next;
        while (second!=null&&second.next!=null){
            first=first.next;
            second=second.next.next;
        }
        return first;
    }


    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) {
            return head;
        }
        ListNode mid=getMid(head);
        ListNode right_start=mid.next;
        mid.next=null;
        ListNode left = sortList(head);
        ListNode right = sortList(right_start);
        return merge(left,right);
    }

    public  ListNode merge(ListNode left,ListNode right){
        ListNode temp = new ListNode();
        ListNode head = temp;
        while (left!=null&&right!=null){
            if(left.val<right.val){
                temp.next=left;
                left=left.next;
            }
            else {
                temp.next=right;
                right=right.next;
            }
            temp=temp.next;
        }

        if (left!=null){
            temp.next=left;
        }
        if (right!=null){
            temp.next=right;
        }
        return head.next;
    }

    public static void main(String[] args) {
        sortList sort = new sortList();
        ListNode list = sort.sortList(head);
        while (list!=null){
            System.out.println(list.val);
            list=list.next;
        }
    }
}
