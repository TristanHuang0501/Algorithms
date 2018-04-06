import java.util.ArrayList;
import java.util.LinkedList;
/**
 *public class TreeNode {
 *    int val = 0;
 *    TreeNode left = null;
 *    TreeNode right = null;
 *
 *    public TreeNode(int val) {
 *        this.val = val;
 *    }
 *}
 *
 * 题目：从上往下打印出二叉树的每个结点，同一层的结点按照从左向右的顺序打印。
 *            层序遍历即可
 */
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {        
        if(root == null) return new ArrayList<Integer>();
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        queue.addLast(root);
        while(! queue.isEmpty()){
            TreeNode tmp = queue.remove();
            result.add(tmp.val);
            if(tmp.left != null) queue.add(tmp.left);
            if(tmp.right != null) queue.add(tmp.right);
        }
        
        return result;
    }
}