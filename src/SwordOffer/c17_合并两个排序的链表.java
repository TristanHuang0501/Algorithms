/**
 * 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
 *
 * 【解】：
 *      仅用4个辅助变量，实现时间复杂度:O(M+N)，空间复杂度:O(1)
 *
 * Created by nibnait on 2016/9/22.
 */
public class Solution{

	/*
	 * 书上的方法：递归
	 *
	 * 空间消耗O(m+n)
	 */
	public static ListNode mergeSortedList(ListNode head1, ListNode head2){
		if (head1 == null) {
			return head2;
		} else if (head2 == null) {
			return head1;
		}

		ListNode temp = new ListNode();
		if (head1.val <= head2.val) {
			temp = head1;
			temp.next = mergeSortedList(head1.next, head2);
		} else {
			temp = head2;
			temp.next = mergeSortedList(head2, head2.next);
		}

		return temp;
	}
}
