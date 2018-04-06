import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1、2、3 、4、5 是某栈压栈序列，
 *     序列4、5、3、2、1 是该压栈序列对应的一个弹出序列，
 *       但4、3、5、1、2 就不可能是该压棋序列的弹出序列。
 */

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null || popA == null || pushA.length == 0 || popA.length == 0 || pushA.length != popA.length) return false;
        
        int index_push = 0;   //当前正在处理的pushA的位置
        int index_pop = 0;    //当前正在处理的popA的位置
        Stack<Integer> stack = new Stack<>();
        
        while(index_pop < popA.length){
            while(index_push < pushA.length && (stack.isEmpty() || popA[index_pop] != stack.peek())){
                stack.push(pushA[index_push++]);
            }
            
            if(popA[index_pop] == stack.peek()){
                stack.pop();
                index_pop++;
            } else {
                return false;
            }
        }
        return true;
    }
}