/*
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"

示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。
 */

package StringPractice;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"fl", "flow", "flight"};
        String[] strs1 = {"ff", ""};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1 || "".equals(strs[0])) {
            return "";
        }
        StringBuilder prefix = new StringBuilder();
        int index = 0;
        prefix.append(strs[index].charAt(index));
        boolean flag = true;
        while (flag) {
            for (String str : strs) {
                if (index >= str.length() || str.charAt(index) != prefix.charAt(index)) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                index++;
                if (index >= strs[0].length()) {
                    return prefix.toString();
                }
                prefix.append(strs[0].charAt(index));
            }
        }
        if (index == 0)
            return "";
        return prefix.toString().substring(0, prefix.length() - 1);
    }

    //首先假设第一个字符串为最小公共前缀，然后去匹配其他字符，匹配不上就去掉末端字符，循环直到所有的字符都满足
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(res) != 0) {
                res = res.substring(0, res.length() - 1);
            }
        }
        return res;
    }
}
