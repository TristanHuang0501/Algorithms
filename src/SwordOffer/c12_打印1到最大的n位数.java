import java.util.Arrays;
/**
 * 输入数字n，按顺序打印出从1最大的n位十进制数。
 * 比如输入3，则打印出1、2、3、4、5、6...... 一直到最大的3位数即999。
 *
 * 【注意】
 * 大数问题：-->用数组
 *  法1：
 *      模拟大数相加，从0开始，每次加1，
 *      直到arr的最高位(倒数第n+1位)有进位时，即最大的n位数已经打印完毕。stop
 *
 *  法2：
 *      递归
 *      打印1 ~ n位的所有十进制数，其实就是从第1位开始设置0~9的全排列，直到递归将最后一个位置设置完毕，开始打印。
 *
 * Created by nibnait on 2016/9/21.
 */
public class Test{
    /**
     * 用数组来模拟大数相加，从0开始，每次加1
     * @param n
     */
    public static void print1ToMaxOfNDigits1(int n){
        if (n <= 0)
            throw new IllegalArgumentException("Invalid args：位数N必须大于0");

        int[] arr = new int[n+1];
        Arrays.fill(arr, 0);

        while (plusOne(arr)){
            printNumber(arr);
        }

    }

    /**
     * 每一次都是对最低位加1，如果发现加完之后>9，则该位清零，同时对上一位加1，循环该过程
     * 当index指向0位，代表已经超过n位，此时需要返回false以结束打印的循环
     * @param arr
     * @return
     */
    private static boolean plusOne(int[] arr){
        boolean carry = true;
        int index = arr.length - 1;
        while (carry && index > 0){
            arr[index] += 1;
            if (arr[index] > 9){
                arr[index] = 0;
                index --;
                continue;
            }
            carry = false;
        }
        if (index == 0) return false;
        return true;
    }

    public static void print1ToMaxOfNDigits2(int n){
        if (n <= 0)
            throw new IllegalArgumentException("Invalid args：位数N必须大于0");
        int[] arr = new int[n];
        Arrays.fill(arr, 0);
        printRecursively(0, arr);
    }

    private static void printRecursively(int i, int[] arr) {
        if (i == arr.length){
            printNumber(arr);
            return;
        }
        for (int j = 0; j < 10; j++) {
            arr[i] = j;
            printRecursively(i+1, arr);
        }
    }

    /**
     * 能不能按照我们的阅读习惯打印数字是面试官设置的另一个陷阱
     * @param arr
     */
    private static void printNumber(int[] arr){
        boolean printNow = false;
        for (int i = 0; i < arr.length; i++) {
            if (printNow == false && arr[i] == 0)
                continue;
            printNow = true;
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
