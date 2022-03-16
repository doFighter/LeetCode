/**
 * @Description
 * @author Fighter
 * @create 2022-03-09 15:04
 */


package day22;

/**
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */

public class Rob {
    int res = 0;
    public void dynamicTracking (int[] nums,int money, int i){
     if (i>=nums.length){
         res = res>money?res:money;
         return;
     }
     dynamicTracking(nums, money+nums[i], i+2);
     dynamicTracking(nums, money, i+1);

    }

    /**
     * 使用递归：超出时间限制
     * @param nums
     * @return
     */
    public int rob_1(int[] nums) {
        int money = 0;
        dynamicTracking(nums, money, 0);
        return res;
    }

    /**
     * 使用直接循环的方式进行动态规划
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        nums[1] = Math.max(nums[0], nums[1]);
        for (int i=2;i<nums.length;i++){
            nums[i] = Math.max(nums[i-2]+nums[i], nums[i-1]);
        }
        return Math.max(nums[nums.length-1],nums[nums.length-2]);
    }


    public static void main(String[] args) {
//        int[] nums = {1,2,3,1};
//        int[] nums = {2,7,9,3,1};
        int[] nums = {2,1,1,2};
        Rob rob = new Rob();
        int rob1 = rob.rob(nums);
        System.out.println(rob1);
    }
}
