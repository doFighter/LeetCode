/**
 * @Description
 * @author Fighter
 * @create 2022-02-11 20:44
 */


package day05;

import java.util.Arrays;

/**
 * 189. 轮转数组
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *
 *
 * 进阶：
 *
 * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 */

public class Rotate {
    /**
     * 暴力法：线性时间复杂度-O(N)，空间复杂度翻倍-O(2N)
     * @param nums
     * @param k
     */
    public int[] rotate1(int[] nums, int k) {
        int[] res = new int[nums.length];
        for (int i=0;i<nums.length;i++){
            res[(i+k)%nums.length] = nums[i];
        }
        return res;
    }

    /**
     * 在原数组上进行轮转：线性时间复杂度-O(N)，空间复杂度翻倍-O(N)
     * @param nums
     * @param k
     * @return
     */
    public int[] rotate2(int[] nums, int k){
        if (k<=0||nums.length<=1||k==nums.length){
            return nums;
        }
        int count = 0;
        int index = 0;
        int target = nums[0];
        int flag = 0;
        while (count<nums.length){
            index = (index + k)%nums.length ;
            int a;
            if (index<=flag){
                a = nums[index+1];
                nums[index] = target;
                index++;
                flag++;
            }else {
                a = nums[index];
                nums[index] = target;
            }
            target = a;
            count++;
        }
        return nums;
    }

    public static void main(String[] args) {
//        int[] nums = {1,2,3,4,5,6,7};
//        int k = 3;
//        int[] nums = {-1,-100,3,99};
//        int k = 2;
        int[] nums = {1,2};
        int k = 3;
//        int[] nums = {1,2,3,4,5,6};
//        int k = 4;
        Rotate r = new Rotate();
        int[] ints = r.rotate2(nums, k);
        System.out.println(Arrays.toString(ints));
    }
}
