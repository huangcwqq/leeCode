/*
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

案例:

s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.


注意事项：您可以假定该字符串只包含小写字母。
 */
package StringPractice;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FirstUniqChar {
    public static void main(String[] args) {
        String s = "leetcode";
        String s1 = "loveleetcode";
        String s2 = "cc";
        System.out.println(firstUniqChar4(s));
    }

    //引入HashMap数组来进行辅助
    public static int firstUniqChar(String s) {
        int n = s.length();
        Map<Character, Integer> tempMap = new HashMap<Character, Integer>();
        for (int i = 0; i < n; i++) {
            Integer value = tempMap.get(s.charAt(i));
            if (value != null) {
                tempMap.put(s.charAt(i), value + 1);
            } else {
                tempMap.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (tempMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    //引入int数组
    public static int firstUniqChar2(String s) {
        int freq[] = new int[26];

        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;

        for (int i = 0; i < s.length(); i++)
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }

    //引入treeMap数组(大佬方法)
    public static int firstUniqChar3(String s) {
        if (s == null || s.equals(""))
            return -1;
        if (s.length() == 1)
            return 0;
        TreeMap<Integer, Character> treeMap = new TreeMap();
        for (char i = 'a'; i <= 'z'; i++) {
            int left = s.indexOf(i);
            if (left == -1) continue;
            int right = s.lastIndexOf(i);
            if (left == right)
                treeMap.put(left, i);
        }
        return treeMap.isEmpty() ? -1 : treeMap.firstKey();
    }

    //前后比较法
    public static int firstUniqChar4(String s) {
        if (s == null || s.equals(""))
            return -1;
        if (s.length() < 2)
            return 0;
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            if (s.indexOf(item) == s.lastIndexOf(item)) {
                return i;
            }
        }
        return -1;
    }
}
