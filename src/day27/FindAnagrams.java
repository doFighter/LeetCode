/**
 * @Description
 * @author Fighter
 * @create 2022-03-19 19:10
 */


package day27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *  示例 2:
 *
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 *
 * 提示:
 *
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 */

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length()<p.length()){
            return res;
        }
        int[] arrS = new int[26];
        int[] arrP = new int[26];
        int l = 0, r = 0;
        for (;r<p.length();r++){
            arrS[s.charAt(r)-'a'] ++;
            arrP[p.charAt(r)-'a'] ++;
        }
        if (Arrays.equals(arrP, arrS)){
            res.add(0);
        }
        while (r<s.length()){
            arrS[s.charAt(l++)-'a']--;
            arrS[s.charAt(r++)-'a']++;
            if (Arrays.equals(arrP,arrS)){
                res.add(l);
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        String s = "cbaebabacd", p = "abc";
        String s="baa" ,p="aa";
        FindAnagrams anagrams = new FindAnagrams();
        List<Integer> anagrams1 = anagrams.findAnagrams(s, p);
        System.out.println(anagrams1.toString());
    }
}
