package SwordOffer;

import java.util.ArrayList;

/**
 * Created by Tristan on 2018/1/5.
 */
public class c14 {
    public void reOrderArray1(int[] array){
        //从左往右，找到第一个奇数
        for(int i = 0; i < array.length; i++){
            //找到奇数后在奇数前面寻找偶数，如果有就把两者之间的数右移一位
            if(array[i]%2 == 1){
                for(int j = 0; j < i; j++){
                    if(array[j]%2 == 0){
                        int temp = array[i];
                        for(int k = i; k > j; k--){
                            array[k] = array[k-1];
                        }
                        array[j] = temp;
                        //移完跳出循环
                        break;
                    }
                }
                //这个位置的奇数搞定了就跳到下一个位置继续寻找奇数
                continue;
            }
        }
    }

    /**
     * 先统计奇数的个数，然后新建一个等长数组，设置两个指针，奇数指针从0开始，偶数指针从奇数个数的末尾开始遍历，填数
     * @param array
     */
    public void reOrderArray(int [] array) {
        if(array.length==0||array.length==1) return;
        int oddCount=0,oddBegin=0;
        int[] newArray=new int[array.length];
        for(int i=0;i<array.length;i++){
            if((array[i]&1)==1) oddCount++;
        }
        for(int i=0;i<array.length;i++){
            if((array[i]&1)==1) newArray[oddBegin++]=array[i];
            else newArray[oddCount++]=array[i];
        }
        for(int i=0;i<array.length;i++){
            array[i]=newArray[i];
        }
    }
}
