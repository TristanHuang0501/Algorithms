package SwordOffer;

import java.util.ArrayList;

/**
 * Created by Tristan on 2018/1/5.
 */
public class c14 {
    /**
     * 先统计奇数的个数，然后新建一个等长数组，设置两个指针，奇数指针从0开始，偶数指针从奇数个数的末尾开始遍历，填数
     * @param array
     */
    public void reOrderArray(int [] array) {
        if(array.length==0||array.length==1) return;
        int oddCount=0,oddBegin=0;
        int[] newArray=new int[array.length];

        //先遍历一遍，统计奇偶数的数目
        for(int i=0;i<array.length;i++){
            if((array[i]&1)==1) oddCount++;
        }
        //再遍历，填充新的数组
        for(int i=0;i<array.length;i++){
            if((array[i]&1)==1) newArray[oddBegin++]=array[i];
            else newArray[oddCount++]=array[i];
        }
        //把值copy过去
        for(int i=0;i<array.length;i++){
            array[i]=newArray[i];
        }
    }
}
