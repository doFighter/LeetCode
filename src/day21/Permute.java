/**
 * @Description
 * @author Fighter
 * @create 2022-03-08 10:11
 */


package day21;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 */

public class Permute {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public void backTracking(int[] nums, int[] visited, int len){
        if (temp.size() == len){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i=0;i<len;i++){
            if (visited[i] == 1){
                continue;
            }
            temp.add(nums[i]);
            visited[i] = 1;
            backTracking(nums, visited, len);
            temp.remove(temp.size()-1);
            visited[i] = 0;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        int[] visited = new int[nums.length];
        backTracking(nums, visited, len);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Permute permute = new Permute();
        List<List<Integer>> permute1 = permute.permute(nums);
        for (List<Integer> list : permute1){
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()){
                System.out.printf(iterator.next().toString()+",");
            }
            System.out.println();
        }
    }
}
