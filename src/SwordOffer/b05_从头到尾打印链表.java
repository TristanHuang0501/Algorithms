/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        addToResult(result, listNode);
        return result;
    }
    
    //用递归，再想一下用栈的方法~
    private void addToResult(ArrayList<Integer> result, ListNode listNode){
        if(listNode == null) return;
        if(listNode.next == null){
            result.add(listNode.val);
            return;
        }
        addToResult(result, listNode.next);
        result.add(listNode.val);
    }
}