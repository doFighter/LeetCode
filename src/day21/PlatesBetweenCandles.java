/**
 * @Description
 * @author Fighter
 * @create 2022-03-08 15:14
 */


package day21;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2055. 蜡烛之间的盘子
 * 给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0 开始的字符串 s ，它只包含字符 '*' 和 '|' ，其中 '*' 表示一个 盘子 ，'|' 表示一支 蜡烛 。
 *
 * 同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] 表示 子字符串 s[lefti...righti] （包含左右端点的字符）。对于每个查询，你需要找到 子字符串中 在 两支蜡烛之间 的盘子的 数目 。如果一个盘子在 子字符串中 左边和右边 都 至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间 。
 *
 * 比方说，s = "||**||**|*" ，查询 [3, 8] ，表示的是子字符串 "*||**|" 。子字符串中在两支蜡烛之间的盘子数目为 2 ，子字符串中右边两个盘子在它们左边和右边 都 至少有一支蜡烛。
 * 请你返回一个整数数组 answer ，其中 answer[i] 是第 i 个查询的答案。
 *
 * 示例 1:
 *
 * ex-1
 *
 * 输入：s = "**|**|***|", queries = [[2,5],[5,9]]
 * 输出：[2,3]
 * 解释：
 * - queries[0] 有两个盘子在蜡烛之间。
 * - queries[1] 有三个盘子在蜡烛之间。
 * 示例 2:
 *
 * ex-2
 *
 * 输入：s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16]]
 * 输出：[9,0,0,0,0]
 * 解释：
 * - queries[0] 有 9 个盘子在蜡烛之间。
 * - 另一个查询没有盘子在蜡烛之间。
 *
 *
 * 提示：
 *
 * 3 <= s.length <= 105
 * s 只包含字符 '*' 和 '|' 。
 * 1 <= queries.length <= 105
 * queries[i].length == 2
 * 0 <= lefti <= righti < s.length
 */

public class PlatesBetweenCandles {
    /**
     * 暴力解法：时间复杂度高
     * @param s
     * @param queries
     * @return
     */
    public int[] platesBetweenCandles_1(String s, int[][] queries) {
        int[] res = new int[queries.length];
        int index = 0;
        for (int[] q: queries){
            boolean flag = false;
            int num = 0;
            for (int i = q[0]; i<=q[1];i++){
                if (!flag && s.charAt(i) == '|'){
                    flag = true;
                }

                if (flag && s.charAt(i) == '*'){
                    num++;
                }

                if (flag && s.charAt(i) == '|'){
                    res[index] = Math.max(res[index], num);
                }
            }
            index++;
        }
        return res;
    }

    /**
     * 双指针法，依旧超出时间限制
     * @param s
     * @param queries
     * @return
     */
    public int[] platesBetweenCandles_2(String s, int[][] queries) {
        int[] res = new int[queries.length];
        int index = 0;
        for (int[] q: queries){
            String temp = s.substring(q[0], q[1]+1);
            int num = 0;
            int st=q[0],ed=q[1];
            for (;st<ed;){
                if (s.charAt(st) == '*'){
                    num++;
                    st++;
                }
                if (s.charAt(ed) == '*'){
                    num++;
                    ed--;
                }
                if (s.charAt(st)=='|'&&s.charAt(ed)=='|'){
                    break;
                }
            }
            if (st == ed){
                res[index] = 0;
            }else {
                temp = temp.replace("|","");
                res[index] = temp.length() - num;
            }
            index++;
        }
        return res;
    }


    public int[] platesBetweenCandles(String s, int[][] queries) {
        int len = s.length();
        int[] lCandle = new int[len];   // 保存离对应位置左边(包含自身位置)最近的蜡烛下标
        int[] rCandle = new int[len];   // 保存离对应位置右边(包含自身位置)最近的蜡烛下标
        int[] lHasPlate = new int[len]; // 保存对应位置左边盘子(包含自身位置)的数量

        if (s.charAt(0) == '|'){
            lCandle[0] = 0;
        }else {
            lCandle[0] = -1;
        }

        if (s.charAt(len-1) == '|'){
            rCandle[len-1] = len-1;
        }else {
            rCandle[len-1] = -1;
        }

        for (int i=1;i<len;i++){
            if (s.charAt(i) == '|'){
                lCandle[i] = i;
            }else {
                lCandle[i] = lCandle[i-1];
            }
        }

        for (int i=len-2;i>=0;i--){
            if (s.charAt(i) == '|'){
                rCandle[i] = i;
            }else {
                rCandle[i] = rCandle[i+1];
            }
        }

        for (int i=1;i<len;i++){
            if (s.charAt(i) == '*'){
                lHasPlate[i] = lHasPlate[i-1] + 1;
            }else {
                lHasPlate[i] = lHasPlate[i-1];
            }
        }

        int[] res = new int[queries.length];
        int index = 0;
        for (int[] q:queries){

            if (lCandle[q[1]]<q[0] || rCandle[q[0]]>q[1]){
                res[index++] = 0;
            }else {
                res[index++] = lHasPlate[lCandle[q[1]]] - lHasPlate[rCandle[q[0]]];
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        String s = "**|**|***|";
//        int[][] queries = {{2,5},{5,9}};
        String s = "**|*******************|**********************************************|************|*********|*****|*********************************************************************************************|***";
        int[][] queries = {{100,164},{6,183}};
//        String s = "||*";
//        int[][] queries = {{2,2}};
        PlatesBetweenCandles betweenCandles = new PlatesBetweenCandles();
        int[] ints = betweenCandles.platesBetweenCandles(s, queries);
        System.out.println(Arrays.toString(ints));
    }
}

//[21,165,91,165,165,72,72,26,26,1,72,72,72,184,1,72,91,72,72,72,165,72,72,72,72,91,72,165,12,184,165,165,72,91,72,165,72,72,0,72,91,72,165,72,91,165,91,165,72,72,72,0,72,165,72,165,72,91,72,72,72,72,72,72,72,72,72,72,165,72,72,26,165,0,72,165,72,19,165,26,91,72,165,72,72,1,165,184,165,72,91,26,91,1,165,72,72,26,72,72,72,91,72,72,26,72,91,72,91,72,72,46,72,26,14,26,72,165,165,14,91,72,72,26,72,72,72,72,72,72,0,72,1,72,72,72,184,91,184,72,72,72,165,165,72,72,1,72,72,1,72,165,26,26,72,72,26,72,72,72,165,184,165,91,72,72,72,165,72,26,72,72,26,72,72,72,91,72,72,26,72,72,72,91,72,165]
//[21,165,91,165,165,72,72,26,26,0,72,72,72,184,0,72,91,72,72,72,165,72,72,72,72,91,72,165,12,184,165,165,72,91,72,165,72,72,0,72,91,72,165,72,91,165,91,165,72,72,72,0,72,165,72,165,72,91,72,72,72,72,72,72,72,72,72,72,165,72,72,26,165,0,72,165,72,19,165,26,91,72,165,72,72,0,165,184,165,72,91,26,91,0,165,72,72,26,72,72,72,91,72,72,26,72,91,72,91,72,72,46,72,26,14,26,72,165,165,14,91,72,72,26,72,72,72,72,72,72,0,72,0,72,72,72,184,91,184,72,72,72,165,165,72,72,0,72,72,0,72,165,26,26,72,72,26,72,72,72,165,184,165,91,72,72,72,165,72,26,72,72,26,72,72,72,91,72,72,26,72,72,72,91,72,165]