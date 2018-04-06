import java.util.ArrayList;
import java.util.Stack;

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
 * 题目：请实现一个函数按照之字形顺序打印二叉树，
 *      即第一行按照从左到右的顺序打印，
 *        第二层按照从右到左的顺序打印，
 *        第三行再按照从左到右的顺序打印，
 *        其他以此类推。
 *
 *【解】：
 *  按之字形顺序打印二叉树需要两个栈。
 *  我们在打印某一行结点时，把下一层的子结点保存到相应的栈里。
 *   - 如果当前打印的是奇数层，则先保存左子结点再保存右子结点到一个栈里；
 *   - 如果当前打印的是偶数层，则先保存右子结点再保存左子结点到第二个栈里。
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if(pRoot == null) return new ArrayList<ArrayList<Integer>>();
        
        Stack<TreeNode> stack_odd = new Stack<>();
        Stack<TreeNode> stack_even = new Stack<>();
        
        stack_odd.push(pRoot);
        int level = 1;          //当前处理的层数
        int current = 1;        //当前层剩余待处理的节点数
        int next = 0;           //下一层的数目
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> ele_result = new ArrayList<>();
        TreeNode tmp;
        
        while(current != 0){
            if((level & 1) == 1){
                tmp = stack_odd.pop();
            } else {
                tmp = stack_even.pop();
            }
            
            current--;
            ele_result.add(tmp.val);
            
            if((level & 1) == 1){
                if(tmp.left != null) {
                    stack_even.push(tmp.left);
                    next++;
                }
                if(tmp.right != null) {
                    stack_even.push(tmp.right);
                    next++;
                }
            } else {
                if(tmp.right != null) {
                    stack_odd.push(tmp.right);
                    next++;
                }
                if(tmp.left != null) {
                    stack_odd.push(tmp.left);
                    next++;
                }
            }
            
            if(current == 0){
                result.add(ele_result);
                ele_result = new ArrayList<Integer>(next);
                current = next;
                next = 0;
                level ++;
            }
        }
        
        return result;
    }

}