package List;

public class a86_partition {

    public ListNode partition(ListNode head, int x) {
        //准备好链表指针
        ListNode leftHead = null, leftTail = null;
        ListNode rightHead = null, rightTail = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < x) {
                //放左区域
                if (leftHead == null) {
                    //左边还没有连东西
                    leftHead = head;
                    leftTail = head;
                } else {
                    //左边的leftHead和leftTail一定都连了东西
                    leftTail.next = head;
                    leftTail = leftTail.next;
                }
            } else {
                //放右边区域
                if (rightHead == null) {
                    rightHead = head;
                    rightTail = head;
                } else {
                    rightTail.next = head;
                    rightTail = rightTail.next;
                }
            }
            head = next;
        }
        if (leftHead == null) {
            //没有左区域
            return rightHead;
        }
        //有左区域
        leftTail.next = rightHead;
        return leftHead;
    }
}
