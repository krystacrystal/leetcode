package List;

public class a2_addTwoNumbers {
    class ListNode {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = null;//最终链表的头结点
        ListNode cur = null;//沿着链表生成
        int sum = 0, carry = 0, num = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val;
            } else if (l1 == null) {
                sum = l2.val ;
            } else if (l2 == null) {
                sum = l1.val ;
            }
            num = (sum + carry) % 10;
            if (ans == null) {
                ans = new ListNode(num);
                cur = ans;
            } else {
                cur.next = new ListNode(num);
                cur = cur.next;
            }
            //更新一下进位信息给下一次用
            carry = sum / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (carry != 0) {
            cur.next = new ListNode(carry);
        }

        return ans;
    }

}
