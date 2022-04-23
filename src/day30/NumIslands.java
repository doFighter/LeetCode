/**
 * @Description
 * @author Fighter
 * @create 2022-04-02 21:04
 */


package day30;

import java.util.Queue;

/**
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 * 示例 1：
 *
 * 输入：grid = [
 *   ['1','1','1','1','0'],
 *   ['1','1','0','1','0'],
 *   ['1','1','0','0','0'],
 *   ['0','0','0','0','0']
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ['1','1','0','0','0'],
 *   ['1','1','0','0','0'],
 *   ['0','0','1','0','0'],
 *   ['0','0','0','1','1']
 * ]
 * 输出：3
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 */

public class NumIslands {

    public void clearIslands(char[][] grid, int row, int col){
        if (grid[row][col] == '1') {
            grid[row][col] = '0';
        }else {
            return;
        }
        if (row-1>=0){
            clearIslands(grid, row-1, col);
        }
        if (col-1>=0){
            clearIslands(grid,row, col-1);
        }
        if (row+1< grid.length){
            clearIslands(grid, row+1, col);
        }
        if (col+1<grid[0].length){
            clearIslands(grid,row, col+1);
        }

    }

    public int numIslands(char[][] grid) {
        int row = grid.length, col = grid[0].length, res = 0;
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (grid[i][j]=='1'){
                    res ++;
                    clearIslands(grid, i, j);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},
        {'1','1','0','0','0'},
        {'0','0','0','0','0'}};

        NumIslands islands = new NumIslands();
        int i = islands.numIslands(grid);
        System.out.println(i);
    }
}
