/**
 * @Description
 * @author Fighter
 * @create 2022-02-11 19:24
 */


package day05;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 *
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 *
 * 进阶：
 *
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 */

public class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int index = end;
        int[] res = new int[nums.length];
        while (start <= end){
            if (nums[end] * nums[end] > nums[start] * nums[start]){
                res[index] = nums[end] * nums[end];
                end--;
            }else {
                res[index] = nums[start] * nums[start];
                start++;
            }
            index--;
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {-4,-1,0,3,10};
        int[] nums = {-7,-3,2,3,11};
        SortedSquares sq = new SortedSquares();
        int[] ints = sq.sortedSquares(nums);
        System.out.println(Arrays.toString(ints));
    }
}
