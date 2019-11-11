/*
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:

输入: "race a car"
输出: false
 */

package StringPractice;

public class Palindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        String s1 = "race a car";
        String s2 = "aa";
        System.out.println(isPalindrome2(s));
    }

    public static boolean isPalindrome(String s) {
        if("".equals(s)){
            return true;
        }
        int start = 0,end = s.length() - 1;
        while (start < end){
            if(s.charAt(start)<48 || (s.charAt(start) > 57 && s.charAt(start) < 65) || (s.charAt(start) > 90 && s.charAt(start) < 97) || s.charAt(start) > 122){
                start++;
                continue;
            }
            if(s.charAt(end)<48 || (s.charAt(end) > 57 && s.charAt(end) < 65) || (s.charAt(end) > 90 && s.charAt(end) < 97) || s.charAt(end) > 122){
                end--;
                continue;
            }
            if(String.valueOf(s.charAt(start)).equalsIgnoreCase(String.valueOf(s.charAt(end)))){
                start++;
                end--;
                continue;
            }else {
                return false;
            }
        }
        return true;
    }

    //在上面的基础上稍微优化
    public static boolean isPalindrome2(String s) {
        if("".equals(s)){
            return true;
        }
        char[] c = s.toCharArray();
        int start = 0,end = s.length() - 1;
        while (start < end){
            if(!Character.isLetterOrDigit(c[start])){
                start++;
                continue;
            }
            if(c[start] >= 65 && c[start] <= 90){
                c[start] = (char)(c[start] - 'A' + 'a');
            }
            if(!Character.isLetterOrDigit(c[end])){
                end--;
                continue;
            }
            if(c[end] >= 65 && c[end] <= 90){
                c[end] = (char)(c[end] - 'A' + 'a');
            }
            if(c[start] == c[end]){
                start++;
                end--;
                continue;
            }else {
                return false;
            }
        }
        return true;
    }
}
