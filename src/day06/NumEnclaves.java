/**
 * @Description
 * @author Fighter
 * @create 2022-02-12 21:27
 */


package day06;

/**
 * 1020. 飞地的数量
 * 给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
 *
 * 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
 *
 * 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * 输出：3
 * 解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
 * 示例 2：
 *
 *
 * 输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * 输出：0
 * 解释：所有 1 都在边界上或可以到达边界。
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 500
 * grid[i][j] 的值为 0 或 1
 */

public class NumEnclaves {
    /**
     * 先从边界为1的位置访问，并将与边界相连的1置为零
     * @param grid
     * @return
     */
    public int numEnclaves1(int[][] grid) {
        // 忽略四个顶点，因为它们无论是0或者1，都对最终答案无影响
        for(int i=1;i<grid.length-1;i++){
            if (grid[i][0] == 1){
                setZeros(grid, i, 0);
            }
            if (grid[i][grid[0].length-1] == 1){
                setZeros(grid, i, grid[0].length-1);
            }
        }
        for(int i = 1;i<grid[0].length-1;i++){
            if (grid[0][i] == 1){
                setZeros(grid, 0, i);
            }
            if (grid[grid.length-1][i] == 1){
                setZeros(grid, grid.length-1, i);
            }
        }
        int count = 0;
        for (int i=1;i< grid.length-1;i++){
            for (int j=1;j< grid[0].length-1;j++){
                if (grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 递归置零函数，将与边界相连的点全部置为0
     * @param grid
     * @param x
     * @param y
     */
    public void setZeros(int[][] grid, int x, int y){
        grid[x][y] = 0;
        if (x-1>=0 && grid[x-1][y]==1){
            setZeros(grid, x-1, y);
        }
        if (x+1<grid.length && grid[x+1][y]==1){
            setZeros(grid, x+1, y);
        }
        if (y-1>=0 && grid[x][y-1]==1){
            setZeros(grid, x, y-1);
        }
        if (y+1< grid[0].length && grid[x][y+1]==1){
            setZeros(grid, x, y+1);
        }
    }

    public static void main(String[] args) {
//        int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
//        int[][] grid = {{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
//        int[][] grid = {{0},{1},{1},{0},{0}};
        int[][] grid = {{0,0,1,1,1,0,1,1,1,0,1},{1,1,1,1,0,1,0,1,1,0,0},{0,1,0,1,1,0,0,0,0,1,0},{1,0,1,1,1,1,1,0,0,0,1},{0,0,1,0,1,1,0,0,1,0,0},{1,0,0,1,1,1,0,0,0,1,1},{0,1,0,1,1,0,0,0,1,0,0},{0,1,1,0,1,0,1,1,1,0,0},{1,1,0,1,1,1,0,0,0,0,0},{1,0,1,1,0,0,0,1,0,0,1}};
        NumEnclaves numEnclaves = new NumEnclaves();
        int i = numEnclaves.numEnclaves1(grid);
        System.out.println(i);
    }
}
