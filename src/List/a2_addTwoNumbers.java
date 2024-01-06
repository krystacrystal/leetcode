package List;

import com.sun.source.tree.LiteralTree;
import org.junit.Test;

public class a2_addTwoNumbers {

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode ans = null;
        ListNode cur = null;
        int sum = 0, carry = 0, val = 0;
        for (; l1 != null || l2 != null;
             l1 = l1 == null ? null : l1.next,
                     l2 = l2 == null ? null : l2.next) {

            sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            val = sum % 10;
            carry = sum / 10;
            if (ans == null) {
                ans = new ListNode(val);
                cur = ans;
            } else {
                cur.next = new ListNode(val);
                cur = cur.next;
            }
        }
        if (carry != 0) {
            cur.next=new ListNode(carry);
        }
        return ans;
    }


    //我自己写的有问题，找不出问题？
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = null;//最终链表的头结点
        ListNode cur = null;//沿着链表生成
        int sum = 0, carry = 0, val = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val;
            } else if (l1 == null) {
                sum = l2.val;
            } else {
                sum = l1.val;
            }
            val = (sum + carry) % 10;
            //更新一下进位信息给下一次用
            carry = sum / 10;
            if (ans == null) {
                ans = new ListNode(val);
                cur = ans;
            } else {
                cur.next = new ListNode(val);
                cur = cur.next;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry != 0) {
            cur.next = new ListNode(1);
        }
        return ans;
    }

    public void printAns(ListNode ans) {
        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }

    @Test
    public void test1() {
        ListNode l1 = new ListNode(9);
        ListNode cur = l1;
        for (int i = 1; i <= 6; i++) {
            cur.next = new ListNode(9);
            cur = cur.next;
        }
        ListNode l2 = new ListNode(9);
        ListNode cur1 = l2;
        for (int i = 1; i <= 3; i++) {
            cur1.next = new ListNode(9);
            cur1 = cur1.next;
        }
        ListNode ans = addTwoNumbers(l1, l2);
        printAns(ans);
    }

}
