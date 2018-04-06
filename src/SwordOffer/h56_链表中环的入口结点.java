/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/

/**
 * 题目：一个链表中包含环，如何找出环的入口结点？
 *
 * /src/nowcoder/b_2nd_Season/bf160824/README.md：题目五：两个单链表相交的一系列问题的第一个小环节
 * 【解】：双指针：
 *       F：一次走两步、S：一次走一步
 *    - 如果有环，则F与S一定会在环中相遇。
 *        相遇时，再来一个指针A：一次走一步，（S：也一次走一步）
 *        则A与S 一定会在入环的第一个节点相遇【一定】，可返回入环的第一个节点。
 *        --------------------------------------------------------------------
 *        相遇时：   F: 2x   S: x   --->   2x-x=kn   n为环中节点数目
 *        所以可以预想，当F重新以1速从头开始的时候，一定会在入口处和S相遇，而相遇时S会多走了kn圈
 *        -------------------------------------------------------------------- 
 *
 *    - 如果无环，
 *        return null;
 */
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead){
        if (pHead == null || pHead.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;   //666
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        //无环
        if (fast == null || fast.next == null) {
            return null;
        }

        // fast重新指向第一个结点
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
