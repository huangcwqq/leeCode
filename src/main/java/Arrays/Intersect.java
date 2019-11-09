/*
给定两个数组，编写一个函数来计算它们的交集。

示例 1:

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2,2]
示例 2:

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [4,9]
说明：

输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
我们可以不考虑输出结果的顺序。
进阶:

如果给定的数组已经排好序呢？你将如何优化你的算法？
如果 nums1 的大小比 nums2 小很多，哪种方法更优？
如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Intersect {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] nums3 = {-2147483648,1,2,3};
        int[] nums4 = {1,-2147483648,-2147483648};
        int[] result = intersect3(nums3,nums4);
        for(int i = 0;i<result.length;i++){
            System.out.print(result[i]);
            System.out.print(",");
        }
    }

    //垃圾方法
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> temp = new ArrayList();
        List<Integer> num1List = new ArrayList();
        List<Integer> num2List = new ArrayList();
        for(int i=0;i<nums1.length;i++){
            num1List.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            num2List.add(nums2[i]);
        }
        Iterator iterator1 = num1List.iterator();
        while (iterator1.hasNext()){
            Integer i = (Integer) iterator1.next();
            Iterator iterator2 = num2List.iterator();
            while (iterator2.hasNext()){
                Integer j = (Integer)iterator2.next();
                if(i.equals(j)){
                    temp.add(j);
                    iterator1.remove();
                    iterator2.remove();
                    break;
                }
            }
        }
        int[] result = new int[temp.size()];
        for(int i=0;i<temp.size();i++){
            result[i] = temp.get(i);
        }
        return result;
    }

    //对方法1进行优化
    public static int[] intersect2(int[] nums1, int[] nums2) {
        List<Integer> temp = new ArrayList();
        List<Integer> num1List = new ArrayList();
        List<Integer> num2List = new ArrayList();
        for(int i=0;i<nums1.length;i++){
            num1List.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            num2List.add(nums2[i]);
        }
        for(Integer num : num2List){
            if(num1List.contains(num)){
                temp.add(num);
                num1List.remove(num);
            }
        }
        int[] result = new int[temp.size()];
        for(int i=0;i<temp.size();i++){
            result[i] = temp.get(i);
        }
        return result;
    }

    //引入map进行优化
    public static int[] intersect3(int[] nums1, int[] nums2) {
        List<Integer> temp = new ArrayList();
        Map<Integer,Integer> tempMap = new HashMap<Integer, Integer>();
        for(int i=0;i<nums1.length;i++){
            Integer value = tempMap.get(nums1[i]);
            if(value == null){
                tempMap.put(nums1[i],1);
            }else {
                tempMap.put(nums1[i],value + 1);
            }
        }
        for(int j = 0;j < nums2.length;j++){
            Integer value = tempMap.get(nums2[j]);
            if(value != null && value >= 1){
                temp.add(nums2[j]);
                tempMap.put(nums2[j],value - 1);
            }
        }
        int[] result = new int[temp.size()];
        for(int i=0;i<temp.size();i++){
            result[i] = temp.get(i);
        }
        return result;
    }

    //对两个数组先进行排序
    public static int[] intersect4(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> temp = new ArrayList();
        int p1 = 0, p2 = 0;
        while(p1 < nums1.length && p2 < nums2.length){
            if(nums2[p2] == nums1[p1]){
                temp.add(nums1[p1]);
                p1 ++;
                p2 ++;
            }else if(nums1[p1] < nums2[p2]){
                p1 ++;
            }else if(nums1[p1] > nums2[p2]){
                p2++;
            }
        }
        int[] res = new int[temp.size()];
        for(int i = 0; i < temp.size(); i ++){
            res[i] = temp.get(i);
        }
        return res;
    }

}
