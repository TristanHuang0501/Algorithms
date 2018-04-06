import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/

/**
 * 题目：从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层打印一行。
 *
 * 【解】：与23题 "d23_从上往下打印二叉树"类似
 *      同样 用一个队列来保存将要打印的结点。
 *      为了把二叉树的每一行单独打印到一行里，我们需要两个变量：
 *       - current：表示在当前的层中还没有打印的结点数，
 *       - next：表示下一层结点的数目。
 */
public class Solution {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if(pRoot == null) return new ArrayList<ArrayList<Integer>>();
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> ele_result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(pRoot);
        int current = 1;
        int next = 0;
        
        while(! queue.isEmpty()){
            TreeNode tmp = queue.remove();
            current--;
            ele_result.add(tmp.val);
            
            if(tmp.left != null) {
                queue.add(tmp.left);
                next++;
            }
            
            if(tmp.right != null){
                queue.add(tmp.right);
                next++;
            }
            
            if(current == 0){
                result.add(ele_result);
                current = next;
                next = 0;
                ele_result = new ArrayList<Integer>(current);
            }
        }
        
        return result;
    }
    
}