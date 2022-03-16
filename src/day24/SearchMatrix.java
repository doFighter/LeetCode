/**
 * @Description
 * @author Fighter
 * @create 2022-03-14 21:03
 */


package day24;

/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 */

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length==0 || matrix[0][0]>target){
            return false;
        }
        int M = matrix.length;
        int N = matrix[0].length;
        for (int i=0;i< M;i++){
            if (matrix[i][N-1]<target){
                continue;
            }
            if (matrix[i][0]>target){
                return false;
            }
            int start = 0;
            int end = N-1;
            while (start<=end){
                int mid = (end-start)/2 + start;
                if (matrix[i][mid] == target){
                    return true;
                }else if (matrix[i][mid]<target){
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
//        int target = 3;
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 13;
        SearchMatrix matrix1 = new SearchMatrix();
        boolean b = matrix1.searchMatrix(matrix, target);
        System.out.println(b);
    }
}
