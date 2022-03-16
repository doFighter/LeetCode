/**
 * @Description
 * @author Fighter
 * @create 2022-02-13 17:25
 */


package day07;

import java.util.Arrays;

/**
 * 1189. “气球” 的最大数量
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 *
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：text = "nlaebolko"
 * 输出：1
 * 示例 2：
 *
 *
 *
 * 输入：text = "loonbalxballpoon"
 * 输出：2
 * 示例 3：
 *
 * 输入：text = "leetcode"
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= text.length <= 10^4
 * text 全部由小写英文字母组成
 */

public class MaxNumberOfBalloons {
    /**
     * 使用固定数组，对对应单词进行计数，然后求取每个字母对应单词权值数
     * @param text
     * @return
     */
    public int maxNumberOfBalloons(String text) {
        if(text.length()<7){
            return 0;
        }
        int[] res = new int[5];
        for (int i=0;i<text.length();i++){
            switch (text.charAt(i)){
                case 'a':
                    res[0] = res[0]+1;
                    break;
                case 'b':
                    res[1] = res[1]+1;
                    break;
                case 'l':
                    res[2] = res[2]+1;
                    break;
                case 'o':
                    res[3] = res[3]+1;
                    break;
                case 'n':
                    res[4] = res[4]+1;
            }
        }
        res[2] = res[2]/2;
        res[3] = res[3]/2;
        int result = res[0];
        for (int i=1;i<5;i++){
            if (result>res[i]){
                result = res[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        String text = "nlaebolko";
        String text = "loonbalxballpoon";
        MaxNumberOfBalloons maxNumberOfBalloons = new MaxNumberOfBalloons();
        int i = maxNumberOfBalloons.maxNumberOfBalloons(text);
        System.out.println(i);
    }
}
