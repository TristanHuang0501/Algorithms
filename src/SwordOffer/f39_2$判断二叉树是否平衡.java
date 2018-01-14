package SwordOffer;

import java.lang.Math;

/**
 * 题目：输入一棵二叉树，判断该二叉树是否是平衡二叉树
 */
public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        //设置两个出口，一个是是平衡的返回true，一个是发现不平衡了返回false
        if(root == null) return true;
        if(Math.abs(TreeDepth(root.left) - TreeDepth(root.right)) > 1) return false;
        
        //尾递归
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
    
    private int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        int depthLeft = TreeDepth(root.left);
        int depthRight = TreeDepth(root.right);
        return depthLeft > depthRight ? depthLeft + 1 : depthRight + 1;
    }
}