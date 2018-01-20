/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre==null || in==null || pre.length != in.length || in.length <= 0){
                return null;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < in.length; i++) {
                map.put(in[i], i);
        }

        return getNode(pre, 0, pre.length-1, in, 0, in.length-1, map);
    }

    /**
     * @param pre 前序遍历数组
     * @param ps  前序遍历开始的位置
     * @param pe  前序遍历结束的位置
     * @param in  中序遍历数组
     * @param is  中序遍历开始的位置
     * @param ie  中序遍历结束的位置
     * @param map 中序数组
     * @return
     */
    private TreeNode getNode(int[] pre, int ps, int pe, int[] in, int is, int ie, HashMap<Integer, Integer> map){
             if (ps > pe){
                    //开始位置大于结束位置，说明已经没有需要处理的元素了
                    return null;
            }

            int value = pre[ps]; //取前序遍历的第一个数字，就是当前的根节点
            int i = 0;
            try{
                    i = map.get(pre[ps]);  //在中序遍历数组中找根节点的位置
            } catch (Exception e){
                    throw new IllegalArgumentException("Invalid args: 前序/中序数组有问题");
            }
            //创建当前根节点
            TreeNode head = new TreeNode(value);
            //递归
            head.left = getNode(pre, ps+1, ps+i-is, in, is, i-1, map);
            head.right = getNode(pre, ps+1+i-is, pe, in, i+1, ie, map);
            return head;
    }
}
