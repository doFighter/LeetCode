/**
 * @Description
 * @author Fighter
 * @create 2022-02-15 20:21
 */


package day09;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */

public class LengthOfLongestSubstring {
    /**
     * 使用窗口移动的方法
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        // 数字字符 ASCII 码在0-127之间，因此创建对应数组，并记录他们在字符串中最晚出现的位置
        int[] last = new int[128];
        for (int i=1;i<128;i++){
            last[i] = -1;
        }
        int start = 0;
        int res = 0;
        for (int i=0;i<s.length();i++){
            int index = s.charAt(i);
            start = Math.max(start,last[index]+1);
            res = Math.max(res,(i-start+1));
            last[index] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
//        String s = "bbbbb";
//        String s = "pwwkew";
//        String s = " ";
//        String s = "dvdf";
        LengthOfLongestSubstring longestSubstring = new LengthOfLongestSubstring();
        int i = longestSubstring.lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
