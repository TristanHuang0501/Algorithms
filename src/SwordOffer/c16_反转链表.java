
/**
 * 题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 *
 * 【思路】
 *  在单链表的表头临时接入一个节点，然后进行尾插法操作。反转单链表。
 *
 */
public class Solution{
	public static ListNode reverseList(ListNode head){
		if (head == null) {
			return null;
		}

		ListNode root = new ListNode();
		root.next = null;
		ListNode next;

		while(head != null){
			// 先把下一个点保存
			next = head.next;
			// 把head处理为root的下一个点，此前先修改head的next
			head.next = root.next;
			root.next = head;
			head = next; 
		}

		return root.next;
	}

	/*
	 * 书上的方法
	 */
	private static ListNode reverseList2(ListNode head){
		if (head == null) {
			return null;
		}

		ListNode reverseHead = null;
		ListNode cur = head;
		ListNode pre = null;  // pre = null， 因为反转后，head.next = null;
		ListNode next = null;

		while(cur != null){
			next = cur.next;

			if (next == null) {
				reverseHead = cur;
			}

			cur.next = pre;
			pre = cur;
			cur = next;
		}

		return reverseHead;
	}
}