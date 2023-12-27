package List;

public class a206_reverseList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            //记录当前节点的下一个节点
            next = head.next;
            //处理当前节点
            head.next = pre;
            //移动pre和next
            pre = head;
            head = next;
        }
        return pre;
    }
}
