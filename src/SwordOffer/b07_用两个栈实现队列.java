import java.util.Stack;

/**
 * 假定两个栈分别为inbox(stack1)和outbox(stack2)；
 * 
 * 对于Enqueue操作，都是对Inbox进行push操作；
 * 对于Dequeue操作，如果outbox栈为空，则将inbox的内容全部倒入outbox，然后弹出。如果outbox不为空，则直接对outbox弹出
 *
 * 该算法的效率在大多数情况下表现良好：
 * Enqueue永远是O(1);
 * Dequeue在大多数情况下表现良好。
 */
public class Solution {
    //inbox和outbox
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    //模拟Enqueue操作
    public void push(int node) {
        stack1.push(node);
    }
    
    //模拟Dequeue操作
    public int pop() {
        if(stack2.empty()){
            if(stack1.empty()){
                throw new RuntimeException("Queue is empty!");
            }
			while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
