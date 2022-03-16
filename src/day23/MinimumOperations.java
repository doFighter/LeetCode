/**
 * @Description
 * @author Fighter
 * @create 2022-03-10 20:34
 */


package day23;

import java.util.*;

/**
 * 2170. 使数组变成交替数组的最少操作数
 * 给你一个下标从 0 开始的数组 nums ，该数组由 n 个正整数组成。
 *
 * 如果满足下述条件，则数组 nums 是一个 交替数组 ：
 *
 * nums[i - 2] == nums[i] ，其中 2 <= i <= n - 1 。
 * nums[i - 1] != nums[i] ，其中 1 <= i <= n - 1 。
 * 在一步 操作 中，你可以选择下标 i 并将 nums[i] 更改 为 任一 正整数。
 *
 * 返回使数组变成交替数组的 最少操作数 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,1,3,2,4,3]
 * 输出：3
 * 解释：
 * 使数组变成交替数组的方法之一是将该数组转换为 [3,1,3,1,3,1] 。
 * 在这种情况下，操作数为 3 。
 * 可以证明，操作数少于 3 的情况下，无法使数组变成交替数组。
 * 示例 2：
 *
 * 输入：nums = [1,2,2,2,2]
 * 输出：2
 * 解释：
 * 使数组变成交替数组的方法之一是将该数组转换为 [1,2,1,2,1].
 * 在这种情况下，操作数为 2 。
 * 注意，数组不能转换成 [2,2,2,2,2] 。因为在这种情况下，nums[0] == nums[1]，不满足交替数组的条件。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 */

public class MinimumOperations {
    public int minimumOperations(int[] nums) {
        if (nums.length<2){
            return 0;
        }
        Map<Integer,Integer> odd_position = new HashMap<>();
        Map<Integer,Integer> even_position = new HashMap<>();

        for (int i=0;i< nums.length;i=i+2){
            even_position.put(nums[i], even_position.getOrDefault(nums[i], 0)+1);
        }
        for (int i=1;i< nums.length;i=i+2){
            odd_position.put(nums[i], odd_position.getOrDefault(nums[i], 0)+1);
        }

        List<Map.Entry<Integer,Integer>> odd_list = new ArrayList<>(odd_position.entrySet());
        Collections.sort(odd_list, (o1,o2)->(o2.getValue()- o1.getValue()));
        int odd_value = odd_list.get(0).getKey();
        List<Map.Entry<Integer,Integer>> even_list = new ArrayList<>(even_position.entrySet());
        Collections.sort(even_list, (o1,o2)->(o2.getValue()- o1.getValue()));
        int even_value = even_list.get(0).getKey();

        if (odd_value == even_value){

            if (odd_list.size()==1 && even_list.size()==1){
                return nums.length/2;
            }else if (odd_list.size()==1){
                even_value = even_list.get(1).getKey();
            }else if (even_list.size() == 1){
                odd_value = odd_list.get(1).getKey();
            }else {
                int odd_even = odd_list.get(0).getValue() + even_list.get(1).getValue();
                int even_odd = even_list.get(0).getValue() + odd_list.get(1).getValue();
                if (odd_even>even_odd){
                    even_value = even_list.get(1).getKey();
                }else {
                    odd_value = odd_list.get(1).getKey();
                }
            }
        }

        int res = 0;
        for (int i=0;i<nums.length;i++){
            if (i%2==0 && nums[i] != even_value){
                res++;
            }else if (i%2==1 && nums[i] != odd_value){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {3,1,3,2,4,3};
        int[] nums = {1,2,2,2,2};
        MinimumOperations operations = new MinimumOperations();
        int i = operations.minimumOperations(nums);
        System.out.println(i);
    }
}
