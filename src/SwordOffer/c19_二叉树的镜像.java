/**
 * 题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 【思路】
 *  先序遍历这棵树的每个结点，
 *  如果遍历到的结点有子结点，就交换它的两个子结点。
 *  当交换完所有非叶子结点的左右子结点之后，就得到了树的镜像。
 *
 * Created by nibnait on 2016/9/23.
 */
public class Solution{
	public void mirror(TreeNode root){
		if (root == null) return;

		//也可以没有这一步，写了的话可以减少一些递归的层数
		if (root.left == null && root.right = null) return;

		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;

		mirror(root.left);
		mirror(root.right);
	}

}