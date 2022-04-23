/**
 * @Description
 * @author Fighter
 * @create 2022-02-16 14:58
 */


package day10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 567. 字符串的排列
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 *
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母
 */

public class CheckInclusion {
    /**
     * 暴力求解：双循环遍历，时间复杂度-O(MlogM),空间复杂度-O(N)  N=s1.length();  M=s2.length();
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion1(String s1, String s2) {
        Map<Character,Integer> map_s1 = new HashMap<>();
        Map<Character,Integer> map_s2 = new HashMap<>();
        for (int i=0;i<s1.length();i++){
            map_s1.put(s1.charAt(i),map_s1.getOrDefault(s1.charAt(i),0)+1);
        }
        int len = 0;
        for (int i=0;i<s2.length();i++){
            if (s2.length()-i<s1.length()){
                return false;
            }
            if (map_s1.getOrDefault(s2.charAt(i),0)==0){
                len = 0;
                continue;
            }
            map_s2.clear();
            for (int j=i;j<s2.length(); j++){
                if (map_s1.getOrDefault(s2.charAt(j),0)==0){
                    i = j;
                    len = 0;
                    break;
                }
                if (map_s2.getOrDefault(s2.charAt(j),0)<map_s1.get(s2.charAt(j))){
                    len++;
                    map_s2.put(s2.charAt(j),map_s2.getOrDefault(s2.charAt(j),0)+1);
                }else {
                    len = 0;
                    break;
                }
                if (len == s1.length()){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 滑动窗口：时间复杂度-O(M),空间复杂度-O(N)  N=s1.length();  M=s2.length();
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion2(String s1, String s2) {
        if (s1.length()>s2.length()){
            return false;
        }
        Map<Character,Integer> map_s1 = new HashMap<>();
        Map<Character,Integer> map_s2 = new HashMap<>();
        int windowsize = s1.length();
        for (int i=0;i<windowsize;i++){
            map_s1.put(s1.charAt(i),map_s1.getOrDefault(s1.charAt(i),0)+1);
            map_s2.put(s2.charAt(i),map_s2.getOrDefault(s2.charAt(i),0)+1);
        }
        for (int i=windowsize;i<s2.length();i++){
            if (map_s1.equals(map_s2)){
                return true;
            }
            if (map_s2.get(s2.charAt(i-windowsize))>1){
                map_s2.put(s2.charAt(i-windowsize),map_s2.get(s2.charAt(i-windowsize))-1);
            }else {
                map_s2.remove(s2.charAt(i-windowsize));
            }
            map_s2.put(s2.charAt(i),map_s2.getOrDefault(s2.charAt(i),0)+1);
        }
        return map_s1.equals(map_s2);
    }

    /**
     * 滑动窗口：不使用Map,使用数组，以节省空间
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion3(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n>m){
            return false;
        }
        int[] nums_s1 = new int[26];
        int[] nums_s2 = new int[26];
        for (int i=0;i<n;i++){
            nums_s1[s1.charAt(i)-'a']++;
            nums_s2[s2.charAt(i)-'a']++;
        }
        for (int j=n;j<m;j++){
            if (Arrays.equals(nums_s1,nums_s2)){
                    return true;
            }
            nums_s2[s2.charAt(j-n)-'a']--;
            nums_s2[s2.charAt(j)-'a']++;
        }
        return Arrays.equals(nums_s1,nums_s2);
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
//        String s1= "ab";
//        String s2 = "eidboaoo";
//        String s1= "hello";
//        String s2 = "ooolleoooleh";
//        String s1= "pqzhi";
//        String s2= "ghrqpihzybre";
        CheckInclusion inclusion = new CheckInclusion();
        boolean b = inclusion.checkInclusion3(s1, s2);
        System.out.println(b);
    }
}
