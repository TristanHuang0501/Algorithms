import java.util.LinkedList;

/**
 * 两个队列模拟一个栈，我们保持任何静止状态下只有一个队列中有元素：
 *     对于push操作：向非空队列中添加元素
 *     对于pop操作：将非空队列中的元素依次弹出并添加到另一个队列中，直到还剩最后一个元素作为返回值
 */
public class Solution{
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        public boolean push(int node){
                //把数据推入到一个非空的队列中即可
                if(queue2.peek() == null）{
                        queue1.offer(node);
                } else {
                        queue2.offer(node);
                }
        }

        public int pop(){
                //将非空队列中的n-1个数据转移到另一个队列中，还剩下的一个返回
                if(queue1.peek() != null){
                        for(int i = 0; i < queue1.size()-1; i++){
                                queue2.offer(queue1.poll());
                        }
                        return queue1.poll();
                } else if(queue2.peek() == null){
                        throw new RuntimeException("Stack is empty");
                } else {
                        for(int i = 0; i < queue2.size()-1; i++){
                                queue1.offer(queue2.poll());
                        }
                        return queue2.poll();
                }
        }
}
