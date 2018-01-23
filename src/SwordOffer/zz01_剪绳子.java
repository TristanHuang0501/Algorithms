/**
 * 题目：剪绳子
 *      给你一根长度为n的绳子，请把绳子剪成m段(m和n都是整数，n>1并且m>1)每段绳子的长度记为k[0],k[1],...,k[m].
 *      请问k[0]*k[1]*...*k[m]可能的最大乘积是多少？
 *      例如，当绳子的长度为8时，我们把它剪成长度分别为2,3,3的三段，此时得到的最大乘积是18.
 */
public class Solution{
    /**
     * 常规的需要O(n^2)的时间复杂度的O(n)的空间复杂度的动态规划思路
     * @param length
     * @return
     */
    public static int maxAfterCutting_solution1(int length) {
        //注意哦，这是在必须切一刀的情况下的最大的乘积
        if (length < 2) return 0;
        if (length == 2) return 1;
        if (length == 3) return 2;

        //子问题的最优解存储在f数组中，数组中的第i个元素表示吧长度为i的绳子剪成若干段后各段乘积的最大值
        int[] f = new int[length + 1];
        //这几个就是有时候不切比切好的情况，所以前后会不一致，想清楚
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;
        f[3] = 3;
        int result = 0;
        for (int i = 4; i <= length; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int num = f[j] * f[i - j];
                max = max < num ? num : max;
                f[i] = max;
            }
        }
        result = f[length];
        return result;
    }

    /** 
     * 贪婪算法
     * 按照如下的策略来剪绳子：
     *      当n>=5时，我们尽可能多地剪长度为3的绳子；
     *      当n=4时，把绳子剪成两段长度为2的绳子；
     *
     * 证明这种思路的正确性：
     *      1. 当n>=5时， 3(n-3) >= 2(n-2) > n;
     *      2. 当n=4的时候其实没有必要剪，但是题目要求剪一刀;
     */
    public int maxAfterCutting_solution2(int length){
        if (length < 2) return 0;
        if (length == 2) return 1;
        if (length == 3) return 2;

        //尽可能多地剪去长度为3的绳子段
        int timesOf3 = length / 3;
        
        //当绳子最后剩下的长度为4的时候，不能再剪去长度为3的绳子段
        //此时更好的方法是把绳子剪成长度为2的两段，以为2*2 > 3*1
        if (length % 3 == 1)
            timesOf3 -= 1;
        
        //括号中的数字要么是4，要么是0
        int timesOf2 = (length - timesOf3 * 3) / 2;
        
        int result = (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
        return result;
    }

    public static void main(String[] args) {
        Test test = new Test();
    }
}
