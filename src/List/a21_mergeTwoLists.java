package List;



public class a21_mergeTwoLists {

    //list1和list2本来也是升序链表
    //用到了链表的双指针技巧
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        //先找谁做头
        ListNode head = list1.val <= list2.val ? list1 : list2;
        ListNode cur = head;
        ListNode cur1 = head.next;//第一个指针
        ListNode cur2 = head == list1 ? list2 : list1;//第二个指针
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        if (cur1 == null) {
            cur.next = cur2;
        }
        if (cur2 == null) {
            cur.next = cur1;
        }
        return head;
    }
}
