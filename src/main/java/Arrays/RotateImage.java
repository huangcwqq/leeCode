/*
给定一个 n × n 的二维矩阵表示一个图像。

将图像顺时针旋转 90 度。

说明：

你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

示例 1:

给定 matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
示例 2:

给定 matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

原地旋转输入矩阵，使其变为:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
 */
package Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix  =
                {
                        {1,2,3},
                        {4,5,6},
                        {7,8,9},
                };
//        int[][] matrix2  =
//                {
//                        {1,2,3,4},
//                        {5,6,7,8},
//                        {9,10,11,12},
//                        {13,14,15,16},
//                };
        int[][] matrix2  =
                {
                        {1,2},
                        {3,4},
                };

        rotate2(matrix2);
        for(int i = 0;i < matrix2.length;i++){
            for(int j = 0;j < matrix2[i].length;j++){
                System.out.print(matrix2[i][j]);
                System.out.print(",");
            }
            System.out.println();
        }
    }

    //使用了另外一个矩阵辅助，不合题意
    public static void rotate(int[][] matrix) {
        if(matrix.length < 2){
            return;
        }
        int[][] result = new int[matrix.length][matrix.length];
        int columnLength = matrix.length - 1;
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[i].length;j++){
                result[j][columnLength] = matrix[i][j];
            }
            columnLength--;
        }
        for(int i = 0;i < result.length;i++){
            for(int j = 0;j < result[i].length;j++){
                matrix[i][j] = result[i][j];
            }
        }
    }

    //找出规律，再用规律解题
    public static void rotate2(int[][] matrix) {
        int len = matrix.length - 1;
        int length = len;
        if(len < 1){
            return;
        }
        for(int i = 0;i < length ;i++){
            for(int j = i;j < length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - j][i];
                matrix[len - j][i] = matrix[len - i][len - j];
                matrix[len - i][len - j] = matrix[j][len - i];
                matrix[j][len - i] = temp;
            }
            length = length - 1;
        }
    }
}
