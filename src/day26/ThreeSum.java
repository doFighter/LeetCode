/**
 * @Description
 * @author Fighter
 * @create 2022-03-18 11:29
 */


package day26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        if (nums.length<3){
            return resList;
        }
        Arrays.sort(nums);
        if (nums[0]>0 || (nums[0]==0 && nums[2]>0)){
            return resList;
        }
        int len = nums.length;
        for (int i=0;i<len-2 && nums[i]<=0;i++){
            if (i>0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j=len-1;j>i+1;j--) {
                if (j<len-1 && nums[j] == nums[j+1]){
                    continue;
                }
                int end = j - 1;
                int start = i + 1;
                while (start <= end) {
                    int mid = (end - start) / 2 + start;
                    int num = nums[mid] + nums[j] + nums[i];
                    if (num == 0) {
                        resList.add(new ArrayList<>(Arrays.asList(nums[i], nums[mid], nums[j])));
                        break;
                    } else if (num < 0) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
        }
        return resList;
    }

    public static void main(String[] args) {
//        int[] nums = {-1,0,1,2,-1,-4};
        int[] nums = {};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(nums);
        System.out.println(lists.toArray());
    }
}
