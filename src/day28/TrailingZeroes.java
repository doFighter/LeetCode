/**
 * @Description
 * @author Fighter
 * @create 2022-03-26 20:52
 */


package day28;

/**
 * 172. 阶乘后的零
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 *
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：0
 * 解释：3! = 6 ，不含尾随 0
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：1
 * 解释：5! = 120 ，有一个尾随 0
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：0
 *
 *
 * 提示：
 *
 * 0 <= n <= 104
 *
 *
 * 进阶：你可以设计并实现对数时间复杂度的算法来解决此问题吗？
 */

public class TrailingZeroes {
    // 直接计算5和2的个数，由于2远比5多，因此只需要计算5的数量
    public int trailingZeroes(int n) {
        if (n<5){
            return 0;
        }
        while (n % 5 != 0){
            n--;
        }
        int num = 0;
        while (n>0){
            n /= 5;
            num += n;
        }
        return num;
    }

    public static void main(String[] args) {
        int n = 30;
        TrailingZeroes zeroes = new TrailingZeroes();
        int i = zeroes.trailingZeroes(n);
        System.out.println(i);
    }
}
