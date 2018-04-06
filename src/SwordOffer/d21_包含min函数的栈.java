import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class Solution {

    Stack<Integer> dataStack;
    Stack<Integer> minStack;
    
    public Solution(){
        dataStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int node) {
        dataStack.push(node);
        if(minStack.isEmpty() || node < minStack.peek()){
            minStack.push(node);
        } else {
            minStack.push(minStack.peek());
        }
    }
    
    public void pop() {
        if(dataStack.isEmpty()){
            throw new RuntimeException("the stack is empty");
        }
        
        dataStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return dataStack.peek();
    }
    
    public int min() {
        return minStack.peek();
    }
}