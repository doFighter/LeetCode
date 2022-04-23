/**
 * @Description
 * @author Fighter
 * @create 2022-02-13 17:53
 */


package day07;

import java.util.Arrays;

/**
 * 344. 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 *
 * 输入：s = ["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 105
 * s[i] 都是 ASCII 码表中的可打印字符
 */

public class ReverseString {
    /**
     * 两端直接交换
     * @param s
     */
    public char[] reverseString(char[] s) {
        for (int i = 0; i < s.length/2; i++) {
            char temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = temp;
        }
        return s;
    }

    public static void main(String[] args) {
//        char[] s = {'h','e','l','l','o'};
        char[] s = {'H','a','n','n','a','h'};
        ReverseString reverseString = new ReverseString();
        char[] chars = reverseString.reverseString(s);
        System.out.println(Arrays.toString(chars));
    }
}
