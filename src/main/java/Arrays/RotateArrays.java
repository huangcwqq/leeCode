/*
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
示例 2:

输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释:
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
说明:

尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
要求使用空间复杂度为 O(1) 的 原地 算法。
 */
package Arrays;

public class RotateArrays {
    public static void main(String[] args) {
        int[] nums = {-1,-100,3,99};
        int[] nums2 = {1,2,3,4,5,6,7};
        rotate3(nums,2);
        for(int i = 0;i < nums.length;i ++){
            System.out.print(nums[i]);
            System.out.print(",");
        }
    }

    //新增一个临时数组（不符合题目要求）
    public static void rotate(int[] nums, int k) {
        if(nums.length < 2 || k == 0){
            return;
        }
        int[] temp = new int[nums.length];
        for(int i = 0;i < nums.length;i++){
            int j = (k + i)%nums.length;
            temp[j] = nums[i];
        }
        for(int i = 0;i<nums.length;i++){
            nums[i] = temp[i];
        }
    }

    //暴力破解法
    public static void rotate2(int[] nums, int k) {
        if(nums.length < 2 || k == 0){
            return;
        }
        while(k > 0){
            int last = nums[nums.length - 1];
            for(int i = nums.length - 1;i >0;i--){
                nums[i] = nums[i-1];
            }
            nums[0] = last;
            k--;
        }
    }

    //大佬方法
    public static void rotate3(int[] nums, int k) {
        int len = nums.length;
        k%=len;
        help(nums, 0, len - k - 1);
        help(nums, len - k, len - 1);
        help(nums, 0, len - 1);
    }

    public static void help(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
