/**
 * Fibonacci数列的几种求解方法
 */
public class Test{
    /**
     * 效率很低的方法，递归由于是从上往下，所以存在着很多的重复计算
     * 比如说求f(10):
     *                f(10)
     *              /      \
     *           f(9)      f(8)
     *          /   \     /    \
     *        f(8)  f(7) f(7)  ...
     *  不难发现，很多结点是重复的，而且重复的结点数会随着n的增大而急剧增加，这意味着计算量会随着n的增大而急剧增大。
     *  事实上，用递归方法计算的时间复杂度是O(n^2)
     */
    public long recursionFibonacci(int n){
        if (n < 2)  return n;
        return recursionFibonacci(n-1) + recursionFibonacci(n-2);
    }

    /**
     * 实用解法是从下往上算
     * 比如
     *   a        b         a+b
     * f(n-2)   f(n-1)     f(n)
     *            |          |
     *            b         a+b      a+2b
     *          f(n-2)     f(n-1)    f(n)
     * 这种思路的时间复杂度是O(n)
     * 在牛客网上测试了一下，两者在时间上的消耗相差近百倍！
     */
    public long Fibonacci(int n){
        if(n < 2) return n;

        long fibNMinusTwo = 0;
        long fibNminusOne = 1;
        long fibN = 0;
        for (int i = 2; i <= n; i++){
            fibN = fibNMinusTwo + fibNminusOne;
            
            fibNMinusTwo = fibNminusOne;
            fibNminusOne = fibN;
        }
        
        return fibN;
    }
}
