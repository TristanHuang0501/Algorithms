/**
 * 98. Validate Binary Search Tree
 *     验证是否是一颗二叉搜索树BST
 */

public class Solution {

	//利用二叉查找树的中序遍历是递增的来验证
	public boolean isValidBST(TreeNode root){
		//查找树的中序遍历为递增的
		if (root == null)  return null;

		TreeNode pre = null; // 上一个结点

		Stack<TreeNode> stack = new Stack<Treenode>();
		TreeNode p = root;

		while(p != null || !stack.isEmpty()){
			//一直向左并将沿途结点压入堆栈
			while(p!= null){
				stack.push(p);
				p = p.left;
			}
			//结点弹出堆栈
			p = stack.pop();
			//访问弹出结点
			if (pre == null || pre.val < p.val) {
				pre = p;
			} else {
				return false;
			}
			//处理右子树，如果right是空，等下回接着弹出上一层，否则呢就从right接着中序遍历
			p = p.right
		}
	}

	//深度优先搜索
	public boolean isValidBST(TreeNode root){
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE); 
	}

	public boolean isValidBST(TreeNode root, long minVal, long maxVal){
		if (root == null)  return null;
		if (root.val >= maxVal || root.val <= minVal) return false; //验证根结点的值是否在值域内

		//根据根节点的值，限定子树节点的值域
		return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
	}
}