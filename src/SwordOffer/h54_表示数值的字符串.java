/**
 * 题目：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串“+100”，“5e2”，“-123”，“3.1416”及”-1E-16”都表示数值，
 *  但“12e”,”1a3.14”,”1.2.3”,”+-5”及“12e+5.4”都不是。 　
 *
 * 【思路分析】：
 *      在数值之前可能有一个表示正负的’-‘或者’+’。
 *      接下来是若干个 0 到 9 的数位表示数值的整数部分（在某些小数里可能没有数值的整数部分）。
 *      如果数值是一个小数，那么在小数点后面可能会有若干个 0 到 9 的数位表示数值的小数部分。
 *      如果数值用科学计数法表示，接下来是一个’e’或者‘E’，以及紧跟着的一个整数（可以有正负号）表示指数。
 *
 *  判断一个字符串是否符合上述模式时，首先看第一个字符是不是正负号。
 *      如果是，在字符串上移动一个字符，继续扫描剩余的字符串中 0 到 9 的数位。
 *      如果是一个小数，则将遇到小数点。
 *      另外，如果是用科学计数法表示的数值，在整数或者小数的后面还有可能遇到’e’或者’E’。
 *
 */

public class Solution{
	public static boolean inNumeric(String str){
		if (str == null || str.length()<1) {
			return false;
		}

		int index = 0;
		if (str.charAt(index) == '+' || str.charAt(index) == '-') {
			index ++;
		}

		if (index > str.length()-1) {
			return false;
		}

		boolean numeric = true;
		index = scanDigits(str, index);

        //如果还没扫描完
		if (index <= str.length()) {
            //如果是小数点
            if (str.charAt(index) == '.') {
                index ++;
                index = scanDigits(str, index);
                //看是否还有指数部分
                if(index >= str.length()){
                        numeric = true;
                } else if (str.charAt(index) == 'e' || str.charAt(index) == 'E'){
                       numeric = isExponential(str, index);
                } else {
                       numeric = false; 
                }
            } else if (str.charAt(index) == 'e' || str.charAt(index) == 'E') {
            	numeric = isExponential(str, index);
            } else {
            	numeric = false;
            }
            return numeric;
		} else {
			return true;
		}
	}

	/**
	 * 判断是否是科学计数法的结尾部分，如E5，e5，E+5，e-5，e(E)后面接整数
	 */
	private boolean isExponential(String str, int index){
		if (index >= str.length() || (str.charAt(index) != 'e' && str.charAt(index) != 'E')) {
			return false;
		}
		index++;
		if (index >= str.length()) {
			returen false;
		}
		if (str.charAt(index) == '+' || str.charAt(index) == '-') {
			index ++;
		}
		if (index >= str.length()) {
			returen false;
		}
		index = scanDigits(str, index);
		return index >= str.length();
	}

	/**
	 * 扫描字符串部分的数字部分
	 * 
     * @param str
     * @param index 开始扫描的位置
     * @return 从扫描位置开始最后一个数字字符的位置
	 */
	private static int scanDigits(String str, int index){
		while(index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9'){
                index ++;
        }
        return index;
	}
}
