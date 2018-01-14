public class Solution {
    public String replaceSpace(StringBuffer str) {
    	StringBuffer newStr = new StringBuffer();
        int length = str.length();
        for(int i = 0; i < length; i++){
            char c = str.charAt(i);
            if(c == ' '){
                newStr.append("%20");
            } else {
                newStr.append(c);
            }
        }
        return newStr.toString();
    }
}