/**
 * @Description
 * @author Fighter
 * @create 2022-02-13 19:29
 */


package day07;

import java.util.HashMap;
import java.util.Map;

/**
 * 2006. 差的绝对值为 K 的数对数目
 * 给你一个整数数组 nums 和一个整数 k ，请你返回数对 (i, j) 的数目，满足 i < j 且 |nums[i] - nums[j]| == k 。
 *
 * |x| 的值定义为：
 *
 * 如果 x >= 0 ，那么值为 x 。
 * 如果 x < 0 ，那么值为 -x 。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2,1], k = 1
 * 输出：4
 * 解释：差的绝对值为 1 的数对为：
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * 示例 2：
 *
 * 输入：nums = [1,3], k = 3
 * 输出：0
 * 解释：没有任何数对差的绝对值为 3 。
 * 示例 3：
 *
 * 输入：nums = [3,2,1,5,4], k = 2
 * 输出：3
 * 解释：差的绝对值为 2 的数对为：
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 * 1 <= k <= 99
 */

public class CountKDifference {
    /**
     * 暴力法：直接循环
     * @param nums
     * @param k
     * @return
     */
    public int countKDifference1(int[] nums, int k) {
        int count = 0;
        for (int i=0;i<nums.length-1;i++){
            for (int j=i+1;j<nums.length;j++){
                if (Math.abs(nums[i]-nums[j])==k){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 牺牲空间提高效率：通过公式|nums[i]-nums[j]|=k,可得nums[i]=nums[j]-k、nums[i]=nums[j]+k
     *      根据要求，可以反过来理解，以[1,2,2,1]为例，即求解：
     *          [1,2]
     *          [1,2,2]
     *
     * @param nums
     * @param k
     * @return
     */
    public int countKDifference2(int[] nums, int k) {
        int count = 0;
        Map<Integer,Integer> res = new HashMap<>();
        for (int i = 0;i<nums.length;i++){
            count += res.getOrDefault(nums[i]+k,0)+res.getOrDefault(nums[i]-k,0);
            res.put(nums[i], res.getOrDefault(nums[i],0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,1};
        int k = 1;
        CountKDifference kDifference = new CountKDifference();
        int i = kDifference.countKDifference2(nums, k);
        System.out.println(i);
    }
}
