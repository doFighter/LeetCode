/**
 * @Description
 * @author Fighter
 * @create 2022-02-18 14:01
 */


package day12;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. 腐烂的橘子
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 *
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 *
 * 示例 1：
 *
 * 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 示例 2：
 *
 * 输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * 示例 3：
 *
 * 输入：grid = [[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] 仅为 0、1 或 2
 */

public class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        int[] x_move = {1,0,-1,0};
        int[] y_move = {0,1,0,-1};

        Queue<int[]> queue = new LinkedList<>();
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        int time = -1;
        int size = queue.size();
        if (size == 0){
            time = 0;
        }
        while (!queue.isEmpty()){
            int[] temp = queue.poll();
            size--;
            int x = temp[0];
            int y = temp[1];
            for (int i=0;i<4;i++){
                int new_x = x+x_move[i];
                int new_y = y+y_move[i];
                if (new_x<N && new_x>=0 && new_y<M && new_y>=0 && grid[new_x][new_y]==1){
                    queue.offer(new int[]{new_x,new_y});
                    grid[new_x][new_y] = 2;
                }
            }
            if (size==0){
                size = queue.size();
                time++;
            }
        }

        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (grid[i][j]==1){
                    return -1;
                }
            }
        }
        return time;
    }

    public static void main(String[] args) {
//        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
//        int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
        int[][] grid = {{0,2}};
        OrangesRotting rotting = new OrangesRotting();
        int i = rotting.orangesRotting(grid);
        System.out.println(i);
    }
}
