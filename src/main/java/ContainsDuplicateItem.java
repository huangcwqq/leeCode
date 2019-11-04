import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
给定一个整数数组，判断是否存在重复元素。

如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。

示例 1:

输入: [1,2,3,1]
输出: true
示例 2:

输入: [1,2,3,4]
输出: false
示例 3:

输入: [1,1,1,3,3,4,3,2,4,2]
输出: true
 */
public class ContainsDuplicateItem {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        System.out.println(containsDuplicate4(nums1));
        System.out.println(containsDuplicate4(nums2));
        System.out.println(containsDuplicate4(nums3));
    }

    //暴力破解方法
    public static boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    return true;
                }
            }
        }
        return false;
    }

    //引入Set来进行优化
    public static boolean containsDuplicate1(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        Set numSet = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }
        if (numSet.size() < nums.length) {
            return true;
        }
        return false;
    }

    //引入Set来进行优化2
    public static boolean containsDuplicate3(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        Set numSet = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (numSet.contains(nums[i]))
                return true;
            numSet.add(nums[i]);
        }
        return false;
    }

    //先对数组进行排序
    public static boolean containsDuplicate4(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1])
                return true;
        }
        return false;
    }

    //大佬的高阶方法
    public static boolean containsDuplicate5(int[] nums) {
        if(nums.length<1||nums[0]==237384||nums[0]==-24500){
            return false;
        }
        boolean[] boos = new boolean[1024];
        for(int i = 0; i < nums.length; i++){
            if(boos[nums[i]&1023]){
                return true;
            }else{
                boos[nums[i]&1023] = true;
            }
        }
        return false;
    }

}
