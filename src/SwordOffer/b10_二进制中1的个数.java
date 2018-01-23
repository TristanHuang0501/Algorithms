/** 
 * 把一个整数减去1之后再和原来的整数做位与运算，得到的结果相当于把整数的二进制表示中最右边的1变成0。很多二进制的问题都可以用这种思路解决。
 */
public class Solution{
    /**
     * 自然想法：
     *     java语言规范中，int型占4个字节，共计32位
     *     那n的二进制表示同 000..0001来与一下
     *     如果结果是1，说明有一位上是1，则计数值加1
     *         结果是0，则计数值不变
     *
     * 注意哦：用>>而不是>>>，因为>>>对负数来说补的是1
     */
    public static int numberOfOneInBinary_1(int n){
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += (n&1);
            n = n >> 1;
        }
        return count;
    }

    /**
     * 这个方法是每次左移1的位置，和上面的方法大同小异
     *
     * 循环的次数等于整数二进制的位数
     */
    public static int numberOfOneInBinary_2(int n){
        int count = 0;
        int flag = 1;
        while(flag != 0){
            if ((n & flag) != 0)
                count++;
            flag = flag << 1;
        }
        return count;
    }

    /**
     * 【惊喜做法】
     *  一个数减去1：（如果一个数不是0，那么它的二进制中至少有1位是1）
     *   - 假设这个数的最后一位是1，那么减去1之后，只是最后一位由1变成了0，其他位不变。
     *   - 最后一位不是1，假设这个数第m位是1，减去1之后，
     *      第m位由1变成了0，m后面的0全部变成了1，m前面的数字不变
     *      这时 n & (n-1)，就可以把m后面的那些1右变回了0，然后再继续 判断、减1
     */
    public static int numberOfOneInBinary_03(int n){
        int count = 0;
        while (n != 0){
            count++;
            n = n & (n-1);
        }
        return count;
    }
}
