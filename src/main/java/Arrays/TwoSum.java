/*
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
 */

package Arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] two = twoSum1(nums, 9);
        System.out.println(two[0] + "," + two[1]);
    }

    //暴力方法
    public static int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return null;
        }
        int two[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    two[0] = i;
                    two[1] = j;
                    return two;
                }
            }
        }
        return null;
    }

    //引入Map来进行优化
    public static int[] twoSum1(int[] nums, int target) {
        if (nums.length < 2) {
            return null;
        }
        int two[] = new int[2];
        Map<Integer, Integer> sumMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (sumMap.containsKey(nums[i])) {
                two[1] = i;
                two[0] = sumMap.get(nums[i]);
                return two;
            } else {
                sumMap.put(target - nums[i], i);
            }
        }
        return null;
    }
}
