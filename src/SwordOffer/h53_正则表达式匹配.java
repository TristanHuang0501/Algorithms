/**
 *  题目：请实现一个函数用来匹配包含‘.’和‘*’的正则表达式。模式中的字符’.’表示任意一个字符，而‘*’表示它前面的字符可以出现任意次（含0次）。
 * 本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串“aaa”与模式“a.a”和“ab*ac*a”匹配，但与“aa.a”及“ab*a”均不匹配。
 */

public class Solution {
    public static boolean match(String input, String pattern){
            if (input == null || pattern == null) 
            	return false;
            return matchCore(input, 0, pattern, 0);
    }

    /**
     * @param i from 0 to input.length()
     * @param p from 0 to input.length()
     */
    private static boolean matchCore(String input, int i, String pattern, int p){
        if (p > pattern.length()-1) {         // pattern reaches the end
        	if (i > input.length()-1) {         // 1. input too
        		return true;
        	} else {                         // 2. input not
        		return false;
        	}
        } else {                             // pattern hasn't come to the end yet
        	if (p+1 <= pattern.length()-1 && pattern.charAt(p+1) == "*") {
        		if (i > input.length()-1) {
        			return matchCore(input, i, pattern, p+2);
        		} else {
        			//  ch* or .*
        			if (pattern.charAt(p) == input.charAt(i) || pattern.charAt(p) == ".") {
		        		return matchCore(input, i+1, pattern, p)        // match "*" n times
        					|| matchCore(input, i+1, pattern, p+2)      // match "*" 1 time
        					|| matchCore(input, i, pattern, p+2);       // match "*" 0 time
        			} else {
        				return matchCore(input, i, pattern, p+2);
        			}
        		}
        	} else {
        		if (i > input.length()-1) {
        			return false;
        		} else {
        			if (input.charAt(i) == pattern.charAt(p) || pattern.charAt(p) == ".") {
        				return matchCore(input, i+1, pattern, p+1);
        			} else {
        				return false;
        			}
        		}
        	}
        }
    }
}

