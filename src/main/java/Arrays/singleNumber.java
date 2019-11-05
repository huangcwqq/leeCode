/*
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:
输入: [2,2,1]
输出: 1
示例 2:

输入: [4,1,2,1,2]
输出: 4
 */

package Arrays;

import java.util.Arrays;

public class singleNumber {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }

    //先对数组进行排序
    public static int singleNumber(int[] nums) {
        int n = nums.length;
        if(n < 2){
            return nums[0];
        }
        Arrays.sort(nums);
        if(nums[0] != nums[1]){
            return nums[0];
        }
        if(nums[n-1] != nums[n-2]){
            return nums[n-1];
        }
        for (int i = 1;i<n-1;i++){
            if(nums[i] != nums[i+1] && nums[i] != nums[i-1]){
                return nums[i];
            }
        }
        return 0;
    }

    //大佬高阶玩法
    public int singleNumber2(int[] nums) {
        int a = 0;
        for (int x : nums) {
            a ^= x;
        }
        return a;
    }
}
