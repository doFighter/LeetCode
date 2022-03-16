/**
 * @Description
 * @author Fighter
 * @create 2022-02-11 18:11
 */


package day05;

/**
 * 1984. 学生分数的最小差值
 * 给你一个 下标从 0 开始 的整数数组 nums ，其中 nums[i] 表示第 i 名学生的分数。另给你一个整数 k 。
 *
 * 从数组中选出任意 k 名学生的分数，使这 k 个分数间 最高分 和 最低分 的 差值 达到 最小化 。
 *
 * 返回可能的 最小差值 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [90], k = 1
 * 输出：0
 * 解释：选出 1 名学生的分数，仅有 1 种方法：
 * - [90] 最高分和最低分之间的差值是 90 - 90 = 0
 * 可能的最小差值是 0
 * 示例 2：
 *
 * 输入：nums = [9,4,1,7], k = 2
 * 输出：2
 * 解释：选出 2 名学生的分数，有 6 种方法：
 * - [9,4,1,7] 最高分和最低分之间的差值是 9 - 4 = 5
 * - [9,4,1,7] 最高分和最低分之间的差值是 9 - 1 = 8
 * - [9,4,1,7] 最高分和最低分之间的差值是 9 - 7 = 2
 * - [9,4,1,7] 最高分和最低分之间的差值是 4 - 1 = 3
 * - [9,4,1,7] 最高分和最低分之间的差值是 7 - 4 = 3
 * - [9,4,1,7] 最高分和最低分之间的差值是 7 - 1 = 6
 * 可能的最小差值是 2
 *
 *
 * 提示：
 *
 * 1 <= k <= nums.length <= 1000
 * 0 <= nums[i] <= 105
 */

import java.util.Arrays;

/**
 * 使用手写的快排算法对数组排序，但事实排序时间太长
 */
//public class MinimumDifference {
//    public int minimumDifference(int[] nums, int k) {
//        if (k==1){
//            return 0;
//        }
//        int begin = 0;
//        int end = nums.length-1;
//        quickShort(nums,begin,end);
//        int res = 100000;
//        for (int i=0;i+k-1<nums.length;i++){
//            if (nums[i] - nums[i+k-1]<res){
//                res = nums[i] - nums[i+k-1];
//            }
//        }
//        return res;
//    }
//
//    /**
//     * 快速排序
//     * @param nums
//     * @param begin
//     * @param end
//     */
//    public void quickShort(int[] nums,int begin,int end){
//        if (begin>=end){
//            return;
//        }
//        int key = nums[begin];
//        int i = begin;
//        int j = end;
//        while (i < j){
//            while (i<j && nums[j]<key){
//                j--;
//            }
//            if (i<j){
//                nums[i] = nums[j];
//            }
//            while (i<j && nums[i]>key){
//                i++;
//            }
//            if (i<j){
//                nums[j] = nums[i];
//            }
//        }
//        nums[i] = key;
//        quickShort(nums,begin,i-1);
//        quickShort(nums,i+1,end);
//    }
//
//    public static void main(String[] args) {
//        int[] nums = {9,4,1,7};
//        int k = 1;
////        int[] nums = {9,4,1,7};
////        int k = 2;
//        MinimumDifference md = new MinimumDifference();
//        int i = md.minimumDifference(nums, k);
//        System.out.println(i);
//    }
//}

public class MinimumDifference {

    public int minimumDifference(int[] nums, int k) {
        if (k==1){
            return 0;
        }
        Arrays.sort(nums);
        int res = 100000;
        for (int i=0;i+k-1<nums.length;i++){
//            if (nums[i+k-1] - nums[i]<res){
//                res = nums[i+k-1] - nums[i];
//            }
            res = Math.min(res,nums[i+k-1] - nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {9,4,1,7};
        int k = 2;
//        int[] nums = {9,4,1,7};
//        int k = 2;
        MinimumDifference md = new MinimumDifference();
        int i = md.minimumDifference(nums, k);
        System.out.println(i);
    }
}
