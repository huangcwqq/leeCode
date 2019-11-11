/*
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321
 示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21
注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
package StringPractice;

public class ReverseInt {
    public static void main(String[] args) {
        int num = 123;
        int num2 = -123;
        int num3 = 1200;
        int num4 = 2147483643;
        int result = reverse2(num3);
        System.out.println(result);
    }

    //蠢方法，转化为字符串进行反转
    public static int reverse(int x) {
        String maxValue = "2147483647";
        String minValue = "-2147483648";
        int num = 0;
        char[] temp;
        String sNum;
        String s = String.valueOf(x);
        if (s.contains("-")) {
            String r = s.replace("-", "");
            char[] c = r.toCharArray();
            temp = reverseChar(c);
            sNum = "-" + new String(temp);
        } else {
            char[] c = s.toCharArray();
            temp = reverseChar(c);
            sNum = new String(temp);
        }
        num = Integer.valueOf(sNum);
        return num;
    }

    private static char[] reverseChar(char[] c) {
        int start = 0;
        int end = c.length - 1;
        for (int i = c.length - 1; i > 0; i--) {
            if (c[i] != '0') {
                end = i;
                break;
            }
        }
        char[] temp = new char[end + 1];
        while (end > -1) {
            temp[start] = c[end];
            start++;
            end--;
        }
        return temp;
    }

    //用取余获取整数的最后一位数字，除法获取十位以上的数字
    public static int reverse2(int x) {
        int result = 0, a;
        while (x != 0) {
            a = x % 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && a > Integer.MAX_VALUE % 10)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && a < Integer.MIN_VALUE % 10)) {
                return 0;
            }
            result = result * 10 + a;
        }
        return result;
    }
}
