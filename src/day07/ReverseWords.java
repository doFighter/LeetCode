/**
 * @Description
 * @author Fighter
 * @create 2022-02-13 18:37
 */


package day07;

/**
 * 557. 反转字符串中的单词 III
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * 示例 2:
 *
 * 输入： s = "God Ding"
 * 输出："doG gniD"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 5 * 104
 * s 包含可打印的 ASCII 字符。
 * s 不包含任何开头或结尾空格。
 * s 里 至少 有一个词。
 * s 中的所有单词都用一个空格隔开。
 */

public class ReverseWords {
    /**
     * 使用空格将字符串分割成字符串数组，再对单个单词进行翻转，最后拼接输出
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        for (int i=0;i<words.length;i++){
            char[] vocabularys = words[i].toCharArray();
            for (int j=0;j<vocabularys.length/2;j++){
                char temp = vocabularys[j];
                vocabularys[j] = vocabularys[vocabularys.length-1-j];
                vocabularys[vocabularys.length-1-j] = temp;
            }
            words[i] = String.valueOf(vocabularys);
        }
        return String.join(" ",words);
    }


    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        ReverseWords reverseWords = new ReverseWords();
        String s1 = reverseWords.reverseWords(s);
        System.out.println(s1);
    }
}
