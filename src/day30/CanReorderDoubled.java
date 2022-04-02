/**
 * @Description
 * @author Fighter
 * @create 2022-04-01 19:55
 */


package day30;

import java.util.ArrayList;
import java.util.List;

/**
 * 954. 二倍数对数组
 * 给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i + 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。
 * 示例 1：
 *
 * 输入：arr = [3,1,3,6]
 * 输出：false
 * 示例 2：
 *
 * 输入：arr = [2,1,2,6]
 * 输出：false
 * 示例 3：
 *
 * 输入：arr = [4,-2,2,-4]
 * 输出：true
 * 解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
 *
 *
 * 提示：
 *
 0 <= arr.length <= 3 * 104
 arr.length 是偶数
 -105 <= arr[i] <= 105
 */

public class CanReorderDoubled {
    /**
     * 使用数组代替字典，时间复杂度O(n),空间复杂度O(m)
     * @param arr
     * @return
     */
    public boolean canReorderDoubled(int[] arr) {
        int[] list = new int[200001];
        for (int i : arr){
            list[i+100000]++;
        }
        for (int i=0;i<200001;i++){
            if (list[i]>0){
                if (i-100000<0){
                    if ((i-100000)%2 != 0){
                        return false;
                    }else {
                        if (list[i] > list[(i-100000)/2+100000]){
                            return false;
                        }else {
                            list[(i-100000)/2+100000] -= list[i];
                            list[i] = 0;
                        }
                    }
                }else if (i-100000>0){
                    if ((i-100000)*2>100000){
                        return false;
                    }else {
                        if (list[i]> list[(i-100000)*2+100000]){
                            return false;
                        }else {
                            list[(i-100000)*2+100000] -= list[i];
                            list[i] = 0;
                        }
                    }
                }else {
                    if (list[100000]%2 != 0){
                        return false;
                    }else {
                        list[100000] = 0;
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
//        int[] arr = {3,1,3,6};
//        int[] arr = {2,1,2,6};
        int[] arr = {2,4,0,0,8,1};
        CanReorderDoubled doubled = new CanReorderDoubled();
        boolean b = doubled.canReorderDoubled(arr);
        System.out.println(b);
    }
}
