/**
 * @Description
 * @author Fighter
 * @create 2022-02-17 9:54
 */


package day11;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 695. 岛屿的最大面积
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 *
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 *
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 *
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 输出：6
 * 解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
 * 示例 2：
 *
 * 输入：grid = [[0,0,0,0,0,0,0,0]]
 * 输出：0
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] 为 0 或 1
 */


public class MaxAreaOfIsland {
    /**
     * 广度优先搜索
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int[] x = {1,0,-1,0};
        int[] y = {0,1,0,-1};
        Queue<int[]> Island = new LinkedList<>();
        int maxArea = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (grid[i][j]==1){
                    grid[i][j] = 0;
                    Island.offer(new int[]{i,j});
                }else {
                    continue;
                }
                int area = 0;
                while (!Island.isEmpty()){
                    int[] peek = Island.poll();
                    area++;
                    for (int t=0;t<4;t++){
                        int xx = peek[0]+x[t];
                        int yy = peek[1]+y[t];
                        if (xx>=0 && xx<n && yy>=0 && yy<m && grid[xx][yy]==1){
                            grid[xx][yy] = 0;
                            Island.offer(new int[]{xx,yy});
                        }
                    }
                }
                if (area>maxArea){
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
//        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        MaxAreaOfIsland areaOfIsland = new MaxAreaOfIsland();
        int i = areaOfIsland.maxAreaOfIsland(grid);
        System.out.println(i);
    }
}
