/*
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */

package StringPractice;

public class Anagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        String s1 = "rat";
        String t1 = "car";
        System.out.println(isAnagram2(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] cs = s.toCharArray();
        char[] ts = t.toCharArray();
        int[] is = new int[26];
        int[] it = new int[26];
        for (int i = 0; i < cs.length; i++) {
            is[cs[i] - 'a']++;
        }
        for (int i = 0; i < ts.length; i++) {
            it[ts[i] - 'a']++;
        }
        for (int i = 0; i < is.length; i++) {
            if (is[i] != it[i]) {
                return false;
            }
        }
        return true;
    }

    //优化
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] cs = s.toCharArray();
        char[] ts = t.toCharArray();
        int[] is = new int[26];
        for (int i = 0; i < cs.length; i++) {
            is[cs[i] - 'a']++;
        }
        for (int i = 0; i < ts.length; i++) {
            if (--is[ts[i] - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}

