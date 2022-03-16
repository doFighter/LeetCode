/**
 * @Description
 * @author Fighter
 * @create 2022-03-09 14:34
 */


package day22;

/**
 * 798. 得分最高的最小轮调
 * 给你一个数组 nums，我们可以将它按一个非负整数 k 进行轮调，这样可以使数组变为 [nums[k], nums[k + 1], ... nums[nums.length - 1], nums[0], nums[1], ..., nums[k-1]] 的形式。此后，任何值小于或等于其索引的项都可以记作一分。
 *
 * 例如，数组为 nums = [2,4,1,3,0]，我们按 k = 2 进行轮调后，它将变成 [1,3,0,2,4]。这将记为 3 分，因为 1 > 0 [不计分]、3 > 1 [不计分]、0 <= 2 [计 1 分]、2 <= 3 [计 1 分]，4 <= 4 [计 1 分]。
 * 在所有可能的轮调中，返回我们所能得到的最高分数对应的轮调下标 k 。如果有多个答案，返回满足条件的最小的下标 k 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,1,4,0]
 * 输出：3
 * 解释：
 * 下面列出了每个 k 的得分：
 * k = 0,  nums = [2,3,1,4,0],    score 2
 * k = 1,  nums = [3,1,4,0,2],    score 3
 * k = 2,  nums = [1,4,0,2,3],    score 3
 * k = 3,  nums = [4,0,2,3,1],    score 4
 * k = 4,  nums = [0,2,3,1,4],    score 3
 * 所以我们应当选择 k = 3，得分最高。
 * 示例 2：
 *
 * 输入：nums = [1,3,0,2,4]
 * 输出：0
 * 解释：
 * nums 无论怎么变化总是有 3 分。
 * 所以我们将选择最小的 k，即 0。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] < nums.length
 */

public class BestRotation {
    public int bestRotation(int[] nums) {
        int len = nums.length;
        int rest = 0;
        int[] res = new int[len]; //对应下标k为轮调数，res[k]表示当轮调数为k时，有几个是刚好不得分
        // 当 k=(i-nums[i] + len)%len，res保存的为刚好得分，然而要求解总得分，无法直接得到，因此当刚好得分再左移一个，便是刚好不得分
        // 当刚好不得分的数目最少时，则的分数目就最多。获取每个k值刚好不得分的个数， 每个下标刚好不得分公式为k=(i-nums[i] + 1 +  len)%len
        // 但是，每当进行轮转的时候，左移一个，nums[0]便开始得分
        for (int i=0;i<len;i++){
            res[(i - nums[i] + 1 + len)%len] += 1;
        }

        for (int i=1;i<len;i++){
            res[i] += res[i-1] - 1;
            if (res[i]<res[rest]){
                rest = i;
            }
        }

        return rest;

    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,4,0};

        BestRotation rotation = new BestRotation();
        int i = rotation.bestRotation(nums);
        System.out.println(i);
    }
}
