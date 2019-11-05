/*
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
示例 2:

输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
 */

package Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {9,9};
//        int[] nums = plusOne(digits);
//        for(int i = 0;i < nums.length;i ++){
//            System.out.print(nums[i]);
//            System.out.print(",");
//        }
        digits = new int[digits.length + 1];
        for(int i = 0;i < digits.length;i ++){
            System.out.print(digits[i]);
            System.out.print(",");
        }

    }

    public static int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        digits[i] = digits[i] + 1;
        for(;i >= 0;i--){
            if(digits[0] > 9){
                digits[0] = 0;
                int[] nums = new int[digits.length + 1];
                nums[0] = 1;
                return nums;
            }else if(digits[i] > 9){
                digits[i] = 0;
                digits[i-1] = digits[i-1] + 1;
            }
        }
        return digits;
    }

    //大佬优化算法
    public int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
