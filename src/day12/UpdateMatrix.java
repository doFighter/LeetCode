/**
 * @Description
 * @author Fighter
 * @create 2022-02-18 12:57
 */


package day12;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 542. 01 矩阵
 * 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 * 示例 1：
 *
 * 输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：[[0,0,0],[0,1,0],[0,0,0]]
 * 示例 2：

 *
 * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
 * 输出：[[0,0,0],[0,1,0],[1,2,1]]

 * 提示：
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * mat[i][j] is either 0 or 1.
 * mat 中至少有一个 0
 */

public class UpdateMatrix {
    /**
     * 广度优先遍历：以0为根节点，按层遍历，各树层数就是各非零点到零的距离
     * @param mat
     * @return
     */
    public int[][] updateMatrix(int[][] mat) {
        int N = mat.length;
        int M = mat[0].length;
        int[] x_move = {1,0,-1,0};
        int[] y_move = {0,1,0,-1};
        int[][] visited = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (mat[i][j]==0){
                    visited[i][j] = 1;
                    queue.offer(new int[]{i,j});
                }
            }
        }
        int step = 0;
        int size = queue.size();
        while (!queue.isEmpty()){
            int[] temp = queue.poll();
            int x = temp[0],y = temp[1];
            mat[x][y] = step;
            size--;
            for (int i=0;i<4;i++){
                int new_x = x + x_move[i];
                int new_y = y + y_move[i];
                if (new_x<0 || new_x>=N || new_y<0 || new_y>=M || visited[new_x][new_y]==1){
                    continue;
                }
                queue.offer(new int[]{new_x,new_y});
                visited[new_x][new_y] = 1;
            }
            if (size==0){
                size = queue.size();
                step++;
            }
        }
        return mat;
    }

    public static void main(String[] args) {
//        int[][] mat = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        UpdateMatrix updateMatrix = new UpdateMatrix();
        int[][] ints = updateMatrix.updateMatrix(mat);
        for (int[] ints1: ints){
            System.out.println(Arrays.toString(ints1));
        }
    }
}
