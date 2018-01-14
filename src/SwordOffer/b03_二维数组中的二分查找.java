/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 【思路】
 * 从二维数组的右上角数p开始比较：
 *     如果target小于p，那么小于p那一列；
 *     如果target大于p，那么大于p那一行；
 *     如果相等就返回；
 * 总的时间复杂度是O(m+n)，m和n分别为数组的行数和列数
 */
public class Solution {
    public boolean Find(int target, int [][] array) {
		int m = array.length;	//行数
        int n = array[0].length;	//列数
        if(m < 1 || n < 1) return false;
        //如果小于最小或者大于最大的就直接返回
        if(target < array[0][0] || target > array[m-1][n-1]){
            return false;
        }
        //设置游标的初始位置为二维数组的右上角
        int x = 0;
        int y = n-1;
        while(x <= m-1 && y >= 0){
            if(target == array[x][y]) return true;
            if(target > array[x][y]) {
                x++;
                continue;
            }
            if(target < array[x][y]) {
                y--;
                continue;
            }
        }
        return false;
    }
}