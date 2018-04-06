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
 * 题目：输入两棵二叉树 A 和 B，判断 B 是不是 A 的子结构。
 *
 * 【解】：
 *      利用二叉树的神级遍历(空间复杂度：O(1)， 时间复杂度：O(h))
 *      转化成字符串匹配问题：KMP算法（时间：O(N)）
 *      总的时间复杂度：O(N)
 *
 */
public class Solution {
    /*
     * 书上的方法，先找到值相同的点，然后递归遍历查看是否相等
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null) return false;
        
        boolean flag = false;
        
        //千万不要把这三个if写到一个if中，那样就只检查了第一个Node其实
        if(root1.val == root2.val){
            flag = isSubtree(root1, root2);
        } 
        
        if(!flag){
            flag = HasSubtree(root1.left, root2);
        }
        
        if(!flag){
            flag = HasSubtree(root1.right, root2);
        }

        return flag;
    }
    
    private boolean isSubtree(TreeNode root1, TreeNode root2){
        if(root2 == null) return true;
        if(root1 == null) return false;
        
        if(root1.val != root2.val){
            return false;
        }
        
        return isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);
    }
}