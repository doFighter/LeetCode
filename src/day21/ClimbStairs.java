/**
 * @Description
 * @author Fighter
 * @create 2022-03-08 21:14
 */


package day21;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 *
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 *
 *
 * 提示：
 *
 * 1 <= n <= 45
 */

public class ClimbStairs {

    int res = 0;

    /**
     * 递归：超时
     * @param n
     */
    public void dynamicPrograming(int n){
        if (n==0){
            res += 1;
            return;
        }

        if (n<0){
            return;
        }

        dynamicPrograming(n-1);
        dynamicPrograming(n-2);
    }

    /**
     * 使用递归求解
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        dynamicPrograming(n);
        return res;
    }

    /**
     * 找规律：
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n<4){
            return n;
        }

        int n1 = 2,res = 3;
        for (int i=4;i<=n;i++){
            int temp = res;
            res += n1;
            n1 = temp;

        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        ClimbStairs climbStairs = new ClimbStairs();
        int i = climbStairs.climbStairs(n);
        System.out.println(i);
    }
}
