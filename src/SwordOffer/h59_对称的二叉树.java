/**
 * 题目：请实现一个函数来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 *【解】：
 *  通常我们有三种不同的二叉树遍历算法，即前序遍历、中序遍历和后序遍历。在这三种遍历算法中，都是先遍历左子结点再遍历右子结点。
 *  我们是否可以定义一种遍历算法，先遍历右子结点再遍历左子结点？
 *  比如我们针对前序遍历定义一种对称的遍历算法，即先遍历父节点，再遍历它的右子结点，最后遍历它的左子结点。
 *  我们发现可以用过比较二叉树的前序遍历序列和对称前序遍历序列来判断二叉树是不是对称的。如果两个序列一样，那么二叉树就是对称的。
 *
 *【注意】：
 *   判断二叉树是否对称，序列化遍历时，叶子结点下面的空指针也要遍历出来，
 *   不然如果二叉树所有结点的value都一样的时候，不管咋遍历，序列化的结果都一样了。。
 *
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 *
 *   public TreeNode(int val) {
 *       this.val = val;
 *   }
 */
*/
public class Solution {
    public boolean isSymmetrical(TreeNode pRoot)
    {
        return isSymmetrical(pRoot, pRoot);
    }
    
    public boolean isSymmetrical(TreeNode pRoot1, TreeNode pRoot2){
        // 注意到结点下面的空指针也要遍历出来
        if(pRoot1 == null && pRoot2 == null) return true;
        if(pRoot1 == null || pRoot2 == null) return false;
        
        if(pRoot1.val != pRoot2.val) return false;
        
        return isSymmetrical(pRoot1.left, pRoot2.right) && isSymmetrical(pRoot1.right, pRoot2.left);
    }
}