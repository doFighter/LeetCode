/**
 * @Description
 * @author Fighter
 * @create 2022-02-17 11:15
 */


package day11;

import java.util.*;

/**
 * 688. 骑士在棋盘上的概率
 * 在一个 n x n 的国际象棋棋盘上，一个骑士从单元格 (row, column) 开始，并尝试进行 k 次移动。行和列是 从 0 开始 的，所以左上单元格是 (0,0) ，右下单元格是 (n - 1, n - 1) 。
 *
 * 象棋骑士有8种可能的走法，如下图所示。每次移动在基本方向上是两个单元格，然后在正交方向上是一个单元格。
 *
 *
 *
 * 每次骑士要移动时，它都会随机从8种可能的移动中选择一种(即使棋子会离开棋盘)，然后移动到那里。
 *
 * 骑士继续移动，直到它走了 k 步或离开了棋盘。
 *
 * 返回 骑士在棋盘停止移动后仍留在棋盘上的概率 。
 *
 *
 *
 * 示例 1：
 *
 * 输入: n = 3, k = 2, row = 0, column = 0
 * 输出: 0.0625
 * 解释: 有两步(到(1,2)，(2,1))可以让骑士留在棋盘上。
 * 在每一个位置上，也有两种移动可以让骑士留在棋盘上。
 * 骑士留在棋盘上的总概率是0.0625。
 * 示例 2：
 *
 * 输入: n = 1, k = 0, row = 0, column = 0
 * 输出: 1.00000
 *
 *
 * 提示:
 *
 * 1 <= n <= 25
 * 0 <= k <= 100
 * 0 <= row, column <= n
 */

public class KnightProbability {
    /**
     * 暴力求解：k太大会超出时间限制，照常线程问题
     * @param n
     * @param k
     * @param row
     * @param column
     * @return
     */
    public double knightProbability1(int n, int k, int row, int column) {
        if (k==0){
            return 1;
        }
        int[] x = {2,0,-2,0};
        int[] y = {0,2,0,-2};
        int[] orthogonal = {1,-1};
        Queue<int[]> result = new LinkedList<>();
        result.offer(new int[]{row,column});
        int flag = 1;
        int step = 0;

        while (!result.isEmpty()){
            int[] poll = result.poll();
            flag--;
            for (int i=0;i<4;i++) {
                int xx = poll[0]+x[i];
                int yy = poll[1]+y[i];
                if (xx>=0 && xx<n && yy>=0 && yy<n){
                    if (x[i]==0){
                        for (int j=0;j<2;j++){
                            int xxo = xx+orthogonal[j];
                            if (xxo>=0 && xxo<n){
                                result.offer(new int[]{xxo,yy});
                            }
                        }
                    }else {
                        for (int j=0;j<2;j++){
                            int yyo = yy+orthogonal[j];
                            if (yyo>=0 && yyo<n){
                                result.offer(new int[]{xx,yyo});
                            }
                        }
                    }
                }
            }
            if (flag==0){
                step++;
                flag = result.size();
            }
            if (step==k){
                break;
            }
        }
        return result.size()/Math.pow(8,k);
    }

    /**
     * 使用深度搜索加动态规划：依旧时间超出限制(递归调用占用太多内存)
     * @param n
     * @param k
     * @param row
     * @param column
     * @return
     */
    public double knightProbability2(int n, int k, int row, int column){
        Map<int[], Double> result = new HashMap<>();
        int[][] step = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{-1,2},{1,-2},{-1,-2}};
        return dfs(n, k, row, column, result, step);

    }

    public double dfs(int n, int k, int row, int column, Map<int[], Double> map, int[][] ints){
        if (row>=n || row<0 || column>=n || column<0){
            return 0;
        }
        if (k==0){
            return 1;
        }
        if (map.containsKey(new int[]{k,row,column})){
            return map.get(new int[]{k,row,column});
        }
        double p = 0;
        for (int[] ints1: ints){
            p += dfs(n, k-1, row+ints1[0], column+ints1[1], map, ints);
        }
        p /= 8.0;
        map.put(new int[]{k, row, column}, p);
        return p;
    }

    /**
     * 动态规划：正向动态规划
     * @param n
     * @param k
     * @param row
     * @param column
     * @return
     */
    public double knightProbability(int n, int k, int row, int column){
        int[][] steps = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{-1,2},{1,-2},{-1,-2}};
        double[][][] dp = new double[k+1][n][n];
        for (int step = 0;step<=k;step++){
            for (int x=0;x<n;x++){
                for (int y=0;y<n;y++){
                    if (step==0){
                        dp[step][x][y] = 1;
                    }else {
                        for (int[] ints: steps){
                            if (x+ints[0]>=0 && x+ints[0]<n && y+ints[1]>=0 && y+ints[1]<n){
                                dp[step][x][y] += dp[step-1][x+ints[0]][y+ints[1]]/8.0;
                            }
                        }
                    }
                }
            }
        }
        return dp[k][row][column];
    }


    public static void main(String[] args) {
//        int n = 8, k = 30, row = 6, column = 4;
//        int n = 3, k = 2, row = 0, column = 0;
        int n = 1, k = 0, row = 0, column = 0;
        KnightProbability probability = new KnightProbability();
        double v = probability.knightProbability(n, k, row, column);
        System.out.println(v);
    }
}
