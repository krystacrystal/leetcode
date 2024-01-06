package List;

public class a206_reverseList {

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

    // 双链表节点
    public static class DoubleListNode {
        public int value;
        public DoubleListNode last;//指向前一个节点
        public DoubleListNode next;//指向后一个节点

        public DoubleListNode(int v) {
            value = v;
        }
    }

    //反转双链表
    public DoubleListNode reverseDoubleList(DoubleListNode head) {
        DoubleListNode pre = null;
        DoubleListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = head.last;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
