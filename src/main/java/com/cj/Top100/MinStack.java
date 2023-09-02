

/**
 * 最小值栈
 *
 * @author CJ_CA
 * @date 2023/08/21
 */
public class MinStack {
    int count;
    Long min=0L;
    ListNode head;
    public MinStack() {
        this.count=0;
    }

    public void push(int val) {
        ListNode node = new ListNode(val-min);
        if(count==0){
            min=(long)val;
            node = new ListNode(0L);
        } else {
            if(val-min<0){
                min=(long)val;
            }
            node.next=head;
        }
        head=node;
        count++;
    }

    public void pop() {
        ListNode node=head;
        head=head.next;
        if(node.val<0){
            min=min-node.val;
        }
        count--;
    }

    public int top() {
        Long val=head.val;
        if(val<0) {
            return Math.toIntExact(min);
        }
        return Math.toIntExact(val+min);
    }

    public int getMin() {
        return Math.toIntExact(min);
    }
}
class ListNode {
    public Long val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(Long val) {
        this.val = val;
    }

    public ListNode(Long val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}