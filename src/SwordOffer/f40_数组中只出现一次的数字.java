package SwordOffer;

import java.util.ArrayList;

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果

public class Solution {
    /**
     *时间O(n^2)的算法
     */
    public void FindNumsAppearOnce1(int [] array,int num1[] , int num2[]) {
        ArrayList<Integer> num = new ArrayList<>();
        for(int i = 0; i < array.length; i++){
            boolean flag = true;
            for(int j = 0; j < array.length; j++){
                if(i != j && array[i] == array[j]){
                    flag = false;
                    break;
                }
            }
            if(flag == true) num.add(array[i]);
        }
        num1[0] = num.get(0);
        num2[0] = num.get(1);
    }

    /**
     * 【解】：
     *  在线处理算法：
     *  1. 假如数组中只有1个数字只出现过一次，其他的都出现了两次，怎么找到它？
     *      我们可以用异或，因为异或：相同为0，不同为1
     *      所以我们可以从头到尾依次异或数组中的每一个数字，最终的异或结果刚好是只出现一次的那个数字。（那些成对出现的两个数字刚好在异或中抵消了）
     *  2. 那数组中又两个只出现一次的数字呢？
     *      我们可以把大数组分成两个子数组啊，每个子数组中都只有1个只出现一次的数字。
     *      这样分：
     *          - 还是从头到位依次异或数组中的每一个数字，最终得到的结果 也是这两个只出现一次的数字异或的结果。
     *          - 假设最终得到的异或结果为 0010，也就是说： 这两个数字的二进制表示时的第3位，一定是一个为1，一个为0
     *          - 因此 我们可以将数组中的所有数字按第3位是1的分成一组，第3位是0的分成一组。
     *          - 然后，再分别求出两个子数组中的那个只出现过一次的数字吧。
     */
    public void FindNumsAppearOnce2(int [] array,int num1[] , int num2[]) {
        //先得出所有数的异或结果
        int temp = 0;
        for(int i : array){
            temp ^= i;
        }
        
        //得到二进制表示下从小到大第一个出现的1的位置
        int index = findFirstOne(temp);
        
        //遍历数组，按照index位置是否为1直接分两组进行异或，最后得到的两个数即所求结果
        num1[0] = 0;
        num2[0] = 0;
        for(int i : array){
            if(isOne(i, index)){
                num1[0] ^= i;
            } else {
                num2[0] ^= i;
            }
        }
    }
    
    private int findFirstOne(int xor){
        int index = 0;
        while(index < 32 && (index & 1) == 0){
            index++;
            xor = xor >> 1;
        }
        return index;
    }
    
    private boolean isOne(int num, int index){
        num = num >> index;
        return (num & 1) == 1;
    }
}