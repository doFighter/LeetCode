/**
 * @Description
 * @author Fighter
 * @create 2022-03-10 12:01
 */


package day23;

/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */

public class SingleNumber {
    /**
     * 巧用异或^,不同的数异或还是原本样子，相同的数异或为零,和0异或为其本身
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i=0;i<nums.length;i++){
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        SingleNumber singleNumber = new SingleNumber();
        int i = singleNumber.singleNumber(nums);
        System.out.println(i);
    }
}
