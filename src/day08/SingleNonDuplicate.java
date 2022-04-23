/**
 * @Description
 * @author Fighter
 * @create 2022-02-14 15:40
 */


package day08;

/**
 * 540. 有序数组中的单一元素
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 *
 * 请你找出并返回只出现一次的那个数。
 *
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums =  [3,3,7,7,10,11,11]
 * 输出: 10
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 */

public class SingleNonDuplicate {
    /**
     * 折半查找：时间复杂度-O(logN),空间复杂度-O(1)
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start<end){
            int mid = start + (end - start)/2;
            if ((mid==0&&nums[mid]!=nums[mid+1])||(mid==nums.length-1&&nums[mid-1]!=nums[mid])||(nums[mid]!=nums[mid-1]&&nums[mid]!=nums[mid+1])){
                return nums[mid];
            }
            if (nums[mid]==nums[mid+1]&&(end-mid)%2==0){
                start = mid;
            }else if (nums[mid]!=nums[mid+1]&&(end-mid)%2!=0){
                start = mid+1;
            }else if (nums[mid]==nums[mid-1]&&(mid-start)%2==0){
                end = mid;
            }else {
                end = mid-1;
            }
        }
        return nums[start];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
//        int[] nums = {1,1,2};
        SingleNonDuplicate nonDuplicate = new SingleNonDuplicate();
        int i = nonDuplicate.singleNonDuplicate(nums);
        System.out.println(i);
    }
}
