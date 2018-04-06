import java.util.ArrayList;
/**
 *public class TreeNode {
 *    int val = 0;
 *    TreeNode left = null;
 *    TreeNode right = null;
 *
 *    public TreeNode(int val) {
 *        this.val = val;
 *
 *    }
 *}
 */
/**
 * 题目：输入一棵二叉树和一个整数， 打印出二叉树中结点值的和为输入整数的所有路径。
 * 【从树的根结点开始往下一直到叶结点所经过的结点形成一条路径】
 *
 * Created by nibnait on 2016/9/26.
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> ele_result = new ArrayList<>();
        
        if(root == null)  return result;
        
        int sum = 0;   //目前的和
        
        findAPath(root, target, result, ele_result, sum);
        
        return result;
    }
    
    private void findAPath(TreeNode root, int target, 
                           ArrayList<ArrayList<Integer>> result, 
                           ArrayList<Integer> ele_result, 
                           int sum){
        //注意：由于int参数是值传递，所以栈中每一帧方法都有自己的值，
        //在最后不需要减去root.val每个栈帧也会回到自己的sum
        //只需要除去ele_result中的最后一一个元素即可，跟随着递归方法调用的压栈出栈恢复现场
        sum += root.val;
        ele_result.add(root.val);
        
        if(root.left == null && root.right == null && sum == target){
            ArrayList<Integer> tmp = new ArrayList<>(ele_result);
            //主要不要在result中直接add引用ele_result，不然结果会随着ele_result的变化全为空
            result.add(tmp);
        }
        
        if(root.left != null){
            findAPath(root.left, target, result, ele_result, sum);
        }
        
        if(root.right != null){
            findAPath(root.right, target, result, ele_result, sum);
        }
        
        ele_result.remove(ele_result.size()-1);
    }
}