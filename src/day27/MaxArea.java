/**
 * @Description
 * @author Fighter
 * @create 2022-03-19 12:51
 */


package day27;

import java.util.Arrays;

/**
 * 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 * 示例 1：
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 *
 * 输入：height = [1,1]
 * 输出：1
 *
 *
 * 提示：
 *
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 */

public class MaxArea {
    /**
     * 双指针解法
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height.length<=1){
            return -1;
        }
        int i=0,j=height.length-1,volume=0;
        while (i<j){
            int h = Math.min(height[i], height[j]);
            volume = Math.max(volume, h*(j-i));
            if (height[i]==h){
                i++;
            }else {
                j--;
            }
        }
        return volume;
    }

    /**
     * 暴力解法
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int maxVolume = 0;
        int len = height.length;

        for (int i=0;i<len-1;i++){
            for (int j=i+1;j<len;j++){
                int boder = Math.min(height[i], height[j]);
                maxVolume = Math.max(maxVolume, boder*(j-i));
            }
        }
        return maxVolume;
    }


    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        MaxArea maxArea = new MaxArea();
        int i = maxArea.maxArea(height);
        System.out.println(i);
    }
}
