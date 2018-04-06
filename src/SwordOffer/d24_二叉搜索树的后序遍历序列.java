/**
 * 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回 true。否则返回 false。
 * 假设输入的数组的任意两个数字都互不相同。
 *
 * 【解】：
 *      递归
 *      盯准根结点所在的位置！
 *
 */
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0) return false;
        
        boolean result = verify(sequence, 0, sequence.length);
        
        return result;
    }
    
    public boolean verify(int [] sequence, int start, int length){
        int root = sequence[length-1];
        
        int i = start;
        
        // i最后的值应为右子树的第一个值对应的Index
        for(; i < length-1; i++){
            if(sequence[i] > root) break;
        }
        
        int start_left = start;
        int len_left = i - start;
        
        int j =  i;
        for(; j < length-1; j++){
            if(sequence[j] < root) return false;
        }
        
        int start_right = i;
        int len_right = length - i - 1;  //注意这个减一哦，要把根结点去掉
        
        boolean left = true;
        if(len_left > 0) left = verify(sequence, start_left, len_left);
        boolean right = true;
        if(len_right > 0) right = verify(sequence, start_right, len_right);
        
        return (left && right);
    }
}