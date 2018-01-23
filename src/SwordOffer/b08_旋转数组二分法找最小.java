/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Test{
    /**
     * 采用二分法
     * 
     * Note：
     *      如果面试题是要求在排序的数组（或者部分排序的数组）中查找一个数字或者统计某个数字出现的次数，
     *      那么我们都可以尝试用二分查找算法。
     * 
     * 还有一个注意点就是特殊情况时需要用顺序查找：
     * 如果array[left] == array[mid] == array[right]， 则无法判断是哪种情况：
     *           /                  /
     *   *-----*-  --*   或者    *--  --*-----* 都是有可能的
     *            /                  /
     * 此时就只能采用顺序查找
     */
    public int minNumberInRotateArray(int [] array) {
        if(array == null  && array.length == 0)
            throw new RuntimeException("Invalid parameters");

        int left = 0;
        int right = array.length - 1;
        int mid = left;
        while (array[left] >= array[right]){
            if (right - left == 1){
                return array[right];
            }

            mid = (left + right) / 2;

            if (array[left] == array[right] & array[left] == array[mid])
                return minInOrder(array);

            //正常情况下就不断二分缩小范围到结束条件：right-left == 1
            if (array[left] <= array[mid]){
                left = mid;
            } else if (array[right] >= array[mid]){
                right = mid;
            }
        }

        //如果上面的while循环没有发生，说明该序列是个常数序列或者没有旋转，直接返回array[left]即可
        return array[mid];
    }

    private int minInOrder(int[] array) {
        int min = a rray[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) min = array[i];
        }
        return min;
    }
}
