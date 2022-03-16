/**
 * @Description
 * @author Fighter
 * @create 2022-02-25 10:25
 */


package day14;

/**
 * 537. 复数乘法
 * 复数 可以用字符串表示，遵循 "实部+虚部i" 的形式，并满足下述条件：
 *
 * 实部 是一个整数，取值范围是 [-100, 100]
 * 虚部 也是一个整数，取值范围是 [-100, 100]
 * i2 == -1
 * 给你两个字符串表示的复数 num1 和 num2 ，请你遵循复数表示形式，返回表示它们乘积的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num1 = "1+1i", num2 = "1+1i"
 * 输出："0+2i"
 * 解释：(1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
 * 示例 2：
 *
 * 输入：num1 = "1+-1i", num2 = "1+-1i"
 * 输出："0+-2i"
 * 解释：(1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。
 *
 *
 * 提示：
 *
 * num1 和 num2 都是有效的复数表示。
 */

public class ComplexNumberMultiply {
    public String complexNumberMultiply(String num1, String num2) {
        String[] num1_list = num1.split("\\+");
        String[] num2_list = num2.split("\\+");
        int real_1 = Integer.parseInt(num1_list[0]);
        int real_2 = Integer.parseInt(num2_list[0]);
        int imaginary_1 = Integer.parseInt(num1_list[1].substring(0,num1_list[1].length()-1));
        int imaginary_2 = Integer.parseInt(num2_list[1].substring(0,num2_list[1].length()-1));
        int real = real_1 * real_2 - imaginary_1 * imaginary_2;
        int imaginary = real_1 * imaginary_2 + real_2 * imaginary_1;
        return real + "+" + imaginary + "i";
    }


    public static void main(String[] args) {
//        String num1 = "1+1i", num2 = "1+1i";
        String num1 = "1+-1i", num2 = "1+-1i";
        ComplexNumberMultiply multiply = new ComplexNumberMultiply();
        String s = multiply.complexNumberMultiply(num1, num2);
        System.out.println(s);
    }
}
