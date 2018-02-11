/**
 * 给定单向链表的头指针和一个结点指针，定义一个函数在0(1)时间删除该结点,
 *
 * 【抖机灵】
 *      正常删除链表节点都得给个头指针和要删除的结点，然后从头开始遍历寻找
 *      但是要求时间复杂度是1，下面抖个机灵：
 *      我们可以直接复制这个结点的下一个结点，然后再将这个结点的下一个结点删除。over
 * 【注意】
 * - 要删除的结点是尾结点
 *     - 没办法，NULL为系统中的特定的那块区域！！并无法复制，所以只能从头遍历，得到该结点的前序结点，删除。
 *     - 如果链表只有一个结点，即这个要删除的结点也是头节点，则，将nodeToBeDeleted置为空之后，还需把头节点置为空；
 * - 由于Java子函数，只能是值传递，（所以不像C++，）必须返回新链表头节点，不然子函数就白调用了。
 */
public class Solution{
        private static ListNode deleteNodeInList(ListNode head, ListNode nodeToBeDeleted){
                if(head == null || nodeToBeDeleted == null){
                        return head;
                }

                if (nodeToBeDeleted.next != null) {  //not the endNode
                        //腾笼换鸟
                        ListNode temp = nodeToBeDeleted.next;
                        nodeToBeDeleted.value = temp.value;
                        nodeToBeDeleted.next = temp.next;
                        temp = null;
                } else if (head == nodeToBeDeleted){  //only one node in the list
                        nodeToBeDeleted = null;
                } else {     //delete the endNode when there are many nodes
                        ListNode temp = head;
                        //find the preNode of endNode
                        while (temp.next != nodeToBeDeleted) {
                                temp = temp.next;
                        }
                        nodeToBeDeleted = null;
                        temp.next = null;
                }
                return head;
        }
}
