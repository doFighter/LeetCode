/**
 * @Description
 * @author Fighter
 * @create 2022-03-08 10:32
 */


package day21;

import java.util.ArrayList;
import java.util.List;

/**
 * 784. 字母大小写全排列
 * 给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
 *
 * 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 * 示例 2:
 *
 * 输入: s = "3z4"
 * 输出: ["3z4","3Z4"]
 *
 *
 * 提示:
 *
 * 1 <= s.length <= 12
 * s 由小写英文字母、大写英文字母和数字组成
 */

public class LetterCasePermutation {
    List<String> res = new ArrayList<>();
    StringBuilder builder = new StringBuilder();

    public void backTracking(int index, String s, int len){
        if (builder.length() == len){
            res.add(builder.toString());
            return;
        }

        builder.append(s.charAt(index));
        backTracking(index+1, s, len);
        if (Character.isLetter(s.charAt(index))){
            char temp = s.charAt(index);
            temp = (char)(temp < 97 ? temp + 32 : temp - 32);
            builder.setCharAt(builder.length()-1, temp);
            backTracking(index+1, s, len);
        }
        builder.deleteCharAt(builder.length()-1);
    }

    public List<String> letterCasePermutation(String s) {
        int len = s.length();
        backTracking(0, s, len);
        return res;
    }

    public static void main(String[] args) {
        String s = "3z4";
        LetterCasePermutation permutation = new LetterCasePermutation();
        List<String> strings = permutation.letterCasePermutation(s);
        for (String s1 : strings){
            System.out.println(s1);
        }
    }
}
