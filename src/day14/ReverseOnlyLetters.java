/**
 * @Description
 * @author Fighter
 * @create 2022-02-25 14:20
 */


package day14;

/**
 * 917. 仅仅反转字母
 * 给你一个字符串 s ，根据下述规则反转字符串：
 *
 * 所有非英文字母保留在原有位置。
 * 所有英文字母（小写或大写）位置反转。
 * 返回反转后的 s 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 *
 * 输入：s = "a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 *
 * 输入：s = "Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 *
 *
 * 提示
 *
 * 1 <= s.length <= 100
 * s 仅由 ASCII 值在范围 [33, 122] 的字符组成
 * s 不含 '\"' 或 '\\'
 */

public class ReverseOnlyLetters {
    /**
     * 双指针解法，头尾同时开始
     * @param s
     * @return
     */
    public String reverseOnlyLetters(String s) {
        StringBuilder builder = new StringBuilder(s);
        int start = 0;
        int end = s.length()-1;
        while (start<end){
            for (;start<end;start++){
                char letter = s.charAt(start);
                if ((letter>=65 && letter<=90)||(letter>=97 && letter<=122)){
                    break;
                }
            }
            for (;end>start;end--){
                char letter = s.charAt(end);
                if ((letter>=65 && letter<=90)||(letter>=97 && letter<=122)){
                    break;
                }
            }
            if (start<end){
                builder.setCharAt(start, s.charAt(end));
                builder.setCharAt(end, s.charAt(start));
                start += 1;
                end -= 1;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
//        String s = "ab-cd";
        String s = "a-bC-dEf-ghIj";
        ReverseOnlyLetters onlyLetters = new ReverseOnlyLetters();
        String s1 = onlyLetters.reverseOnlyLetters(s);
        System.out.println(s1);
    }
}
