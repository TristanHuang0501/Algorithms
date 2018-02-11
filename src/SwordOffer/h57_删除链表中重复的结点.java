/**
 * 题目：在一个排序的链表中，如何删除重复的结点？
 * 例如，1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5 -> null 中重复结点被删除之后，链表变成了：
 *      1 -> 2 -> 5 -> null
 *
 * 【注意陷阱】：
 *      头结点也可能被删除，所以在链表头添加一个临时头结点 root。
 *      然后，最后返回 root.next即可
 *
 * Created by nibnait on 2016/10/3.
 */
/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution{
        private static ListNode deleteDuplication(ListNode head){
                if (head == null) {
                        return null;
                }

                ListNode root = new ListNode();
                root.next = head;   // 临时的头结点

                ListNode prev = root;   //当前结点的前驱
                ListNode node = head;   //当前处理的结点
                // node != null 的意义在于防止整个list都是一个重复的数，如{1,1,1,1,1}，导致node = node.next之后变成null
                while (node != null && node.next != null) {
                        if (node.value == node.next.value) {
                                while (node.next != null && node.next.value = node.value) {
                                        node = node.next; //指向重复结点的最后一个
                                }
                                prev.next = node.next;
                        } else {
                                prev = node;
                        }
                        node = node.next;
                }
                return root.next;
        }
} 
