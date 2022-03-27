/**
 * @Description
 * @author Fighter
 * @create 2022-03-26 19:42
 */


package day28;

import java.util.ArrayList;
import java.util.List;

/**
 * 682. 棒球比赛
 * 你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
 *
 * 比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
 *
 * 整数 x - 表示本回合新获得分数 x
 * "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
 * "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * 请你返回记录中所有得分的总和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：ops = ["5","2","C","D","+"]
 * 输出：30
 * 解释：
 * "5" - 记录加 5 ，记录现在是 [5]
 * "2" - 记录加 2 ，记录现在是 [5, 2]
 * "C" - 使前一次得分的记录无效并将其移除，记录现在是 [5].
 * "D" - 记录加 2 * 5 = 10 ，记录现在是 [5, 10].
 * "+" - 记录加 5 + 10 = 15 ，记录现在是 [5, 10, 15].
 * 所有得分的总和 5 + 10 + 15 = 30
 * 示例 2：
 *
 * 输入：ops = ["5","-2","4","C","D","9","+","+"]
 * 输出：27
 * 解释：
 * "5" - 记录加 5 ，记录现在是 [5]
 * "-2" - 记录加 -2 ，记录现在是 [5, -2]
 * "4" - 记录加 4 ，记录现在是 [5, -2, 4]
 * "C" - 使前一次得分的记录无效并将其移除，记录现在是 [5, -2]
 * "D" - 记录加 2 * -2 = -4 ，记录现在是 [5, -2, -4]
 * "9" - 记录加 9 ，记录现在是 [5, -2, -4, 9]
 * "+" - 记录加 -4 + 9 = 5 ，记录现在是 [5, -2, -4, 9, 5]
 * "+" - 记录加 9 + 5 = 14 ，记录现在是 [5, -2, -4, 9, 5, 14]
 * 所有得分的总和 5 + -2 + -4 + 9 + 5 + 14 = 27
 * 示例 3：
 *
 * 输入：ops = ["1"]
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= ops.length <= 1000
 * ops[i] 为 "C"、"D"、"+"，或者一个表示整数的字符串。整数范围是 [-3 * 10^4, 3 * 10^4]
 * 对于 "+" 操作，题目数据保证记录此操作时前面总是存在两个有效的分数
 * 对于 "C" 和 "D" 操作，题目数据保证记录此操作时前面总是存在一个有效的分数
 */

public class CalPoints {
    /**
     * 暴力求解
     * @param ops
     * @return
     */
    public int calPoints1(String[] ops) {
        List<Integer> resList = new ArrayList<>();
        int sum = 0;
        int temp;
        for (String s: ops){
            switch (s){
                case "+":
                    temp = resList.get(resList.size()-1)+resList.get(resList.size()-2);
                    sum += temp;
                    resList.add(temp);
                    break;
                case "D":
                    temp = resList.get(resList.size()-1)*2;
                    sum += temp;
                    resList.add(temp);
                    break;
                case "C":
                    sum -= resList.get(resList.size()-1);
                    resList.remove(resList.size()-1);
                    break;
                default:
                    temp = Integer.valueOf(s);
                    sum += temp;
                    resList.add(temp);
            }
        }
        return sum;
    }

    /**
     * 本想缩减空间使用率，但在该问题中，存在极端问题，便是加入数字后有多个无效，因此需要对所有数字进行保存，可以直接使用int数组
     * @param ops
     * @return
     */
    public int calPoints(String[] ops) {
        int[] resList = new int[ops.length];
        int sum = 0;
        int i = -1;
        for (String s: ops){
            switch (s){
                case "+":
                    i++;
                    resList[i] = resList[i-1]+resList[i-2];
                    sum += resList[i];
                    break;
                case "D":
                    i++;
                    resList[i] = resList[i-1] * 2;
                    sum += resList[i];
                    break;
                case "C":
                    sum -= resList[i];
                    i--;
                    break;
                default:
                    i++;
                    resList[i] = Integer.valueOf(s);
                    sum += resList[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
//        String[] ops = {"5","2","C","D","+"};
        String[] ops = {"36","28","70","65","C","+","33","-46","84","C"};
        CalPoints points = new CalPoints();
        int i = points.calPoints(ops);
        System.out.println(i);
    }
}
