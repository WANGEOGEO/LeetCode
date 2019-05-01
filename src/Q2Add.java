import java.util.ArrayList;
import java.util.List;

public class Q2Add {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // answer用来装答案
        ListNode answer = new ListNode(0);
        // one是指向l1不同位置的指针。two同理
        ListNode one = l1;
        ListNode two = l2;
        // current用于指向我现在想操作的answer部分。
        ListNode current = answer;
        int carry = 0;
        while (one != null || two != null) {
            int oneValue = (one != null) ? one.val : 0;
            int twoValue = (two != null) ? two.val : 0;
            int sum = carry + oneValue + twoValue;
            //整数除整数，必定留carry
            carry = sum / 10;
            //因为我们第一位已经占住了一个，所以永远都拿后一位来存这一位发生的事。
            current.next = new ListNode(sum % 10);
            //把指针往后指一位。
            current = current.next;
            if (one != null) {
                one = one.next;
            }
            if (two != null) {
                two = two.next;
            }
        }
        //当我们走出上面这个循环的时候，这就说明，两个input的所有位的相加已经都处理完了。
        //唯一有可能没处理的就是，最后一位相加产生carry，那么那个carry还没被加到后面。
        //那么如果确实有这么一个carry位，把他加到后面去就可以了。
        if (carry == 1) {
            current.next = new ListNode(carry);
        }
        //这里千万不能忘了，把最开始的那个0去掉。
        return answer.next;
    }

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode dummyHead = new ListNode(0);
//        ListNode p = l1, q = l2, curr = dummyHead;
//        int carry = 0;
//        while (p != null || q != null) {
//            int x = (p != null) ? p.val : 0;
//            int y = (q != null) ? q.val : 0;
//            int sum = carry + x + y;
//            carry = sum / 10;
//            curr.next = new ListNode(sum % 10);
//            curr = curr.next;
//            if (p != null) p = p.next;
//            if (q != null) q = q.next;
//        }
//        if (carry > 0) {
//            curr.next = new ListNode(carry);
//        }
//        return dummyHead.next;
//    }

}
