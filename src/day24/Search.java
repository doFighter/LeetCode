/**
 * @Description
 * @author Fighter
 * @create 2022-03-14 16:45
 */


package day24;

/**
 * 33. 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [1], target = 0
 * 输出：-1
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -10^4 <= target <= 10^4
 *
 *
 * 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
 */

public class Search {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len==0){
            return -1;
        }
        // 判断是否经过旋转，默认是
        int start = 0;
        int end = len-1;
        if (nums[0]>nums[len-1]){
            int i=0;
            while (nums[i]<nums[i+1]){
                i++;
            }
            if (nums[i]<target || nums[i+1]>target){
                return -1;
            }else if (nums[start]<=target){
                end = i;
            }else {
                start = i+1;
            }
        }


        while (start<=end){
            int mid = (end-start)/2 + start;
            if (nums[mid]<target){
                start = mid + 1;
            }else if (nums[mid]>target){
                end = mid -1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] nums = {4,5,6,7,0,1,2};
//        int target = 0;
//        int[] nums = {4,5,6,7,0,1,2};
//        int target = 3;
        int[] nums = {3,1};
        int target = 1;
        Search search = new Search();
        int search1 = search.search(nums, target);
        System.out.println(search1);
    }
}
