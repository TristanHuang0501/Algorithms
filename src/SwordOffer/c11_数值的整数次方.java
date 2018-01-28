package com.tristan.tcp;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Test{
    /**
     * 注意边界情况，底数为0，指数为0或负数等。
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent){
        //底数为0时返回的具体是什么需要与面试官讨论，或者看题目具体要求
        if (base == 0) throw new RuntimeException("Zero is not suitable for the base");

        if (exponent == 0) return 1;

        double result = powerWithAbsExponent(base, exponent > 0 ? exponent : -exponent);

        return exponent > 0 ? result : 1 / result;
    }

    /**
     * 利用如下公式求a的n次方，可以利用递归快速计算乘方：
     *      a^n = a^(n/2) * a^(n/2)                  n为偶数
     *          = a^((n-1)/2) * a^((n-1)/2) * a      n为奇数
     * 这个公式在用O(log n)时间求菲波那切数列时就涉及到这个公式，可以很容易用递归来实现
     *
     * @param base
     * @param absExponent
     * @return
     */
    private double powerWithAbsExponent(double base, int absExponent) {
       if (absExponent == 1) return base;

       double result = powerWithAbsExponent(base, absExponent >> 1);
       result *= result;
       //如果是奇数，那么还需要再乘以一个 base
       if ((absExponent & 1) == 1) result *= base;

       return result;
    }
}
