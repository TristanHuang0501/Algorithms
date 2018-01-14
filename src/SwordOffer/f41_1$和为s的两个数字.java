import java.util.ArrayList;

/**
 * 题目：输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 对于每个测试案例，输出两个数，小的先输出。
 */
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int left = 0;
        int right = array.length - 1;
        for(; left < array.length; left++){
            while(left < right){
                if(array[left] + array[right] == sum){
                    result.add(array[left]);
                    result.add(array[right]);
                    //找到了立刻返回
                    return result;
                }
                right--;
            }
            right = array.length - 1;
        }
        //没找到
        return result;
    }
}