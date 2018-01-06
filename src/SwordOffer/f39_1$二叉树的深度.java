package SwordOffer;

/**
 * 结点类
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

/**
 * 题目：输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）
 * 形成树的一条路径，最长路径的长度为树的深度。
 */
public class f39_1 {
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        int depthLeft = TreeDepth(root.left);
        int depthRight = TreeDepth(root.right);
        return depthLeft > depthRight ? depthLeft + 1 : depthRight + 1;
    }
}
