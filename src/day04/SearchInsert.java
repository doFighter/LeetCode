/**
 * @Description
 * @author Fighter
 * @create 2022-02-10 20:49
 */


package day04;

public class SearchInsert {
    public int searchInsert(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while (left <= right){
            mid = left + (right - left)/2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        if (left>=nums.length || nums[left] > target){
            return left;
        }else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 4;
        SearchInsert searchInsert = new SearchInsert();
        int i = searchInsert.searchInsert(nums, target);
        System.out.println(i);
    }
}
