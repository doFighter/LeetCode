/**
 * @Description
 * @author Fighter
 * @create 2022-03-07 19:39
 */


package day20;

/**
 *504. 七进制数
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 *
 *
 *
 * 示例 1:
 *
 * 输入: num = 100
 * 输出: "202"
 * 示例 2:
 *
 * 输入: num = -7
 * 输出: "-10"
 *
 *
 * 提示：
 *
 * -107 <= num <= 107
 */

public class ConvertToBase7 {
    public String convertToBase7_1(int num) {
        if (num==0){
            return ""+0;
        }
        String res = "";
        String temp = "";
        if (num<0){
            temp += "-";
            num = -num;
        }
        while (num>0){
            res = (num%7) + res;
            num /= 7;
        }
        return temp + res;
    }

    public String convertToBase7(int num) {
        return Integer.toString(num, 7);
    }

    public static void main(String[] args) {
        int num = -7;
        ConvertToBase7 convert = new ConvertToBase7();
        String s = convert.convertToBase7(num);
        System.out.println(s);
    }
}
