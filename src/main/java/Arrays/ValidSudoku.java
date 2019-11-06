/*
判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。

数独部分空格内已填入了数字，空白格用 '.' 表示。

示例 1:

输入:
[
  ['5','3','.','.','7','.','.','.','.'],
  ['6','.','.','1','9','5','.','.','.'],
  ['.','9','8','.','.','.','.','6','.'],
  ['8','.','.','.','6','.','.','.','3'],
  ['4','.','.','8','.','3','.','.','1'],
  ['7','.','.','.','2','.','.','.','6'],
  ['.','6','.','.','.','.','2','8','.'],
  ['.','.','.','4','1','9','.','.','5'],
  ['.','.','.','.','8','.','.','7','9']
]
输出: true
示例 2:

输入:
[
  ['8','3','.','.','7','.','.','.','.'],
  ['6','.','.','1','9','5','.','.','.'],
  ['.','9','8','.','.','.','.','6','.'],
  ['8','.','.','.','6','.','.','.','3'],
  ['4','.','.','8','.','3','.','.','1'],
  ['7','.','.','.','2','.','.','.','6'],
  ['.','6','.','.','.','.','2','8','.'],
  ['.','.','.','4','1','9','.','.','5'],
  ['.','.','.','.','8','.','.','7','9']
]
输出: false
解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
说明:

一个有效的数独（部分已被填充）不一定是可解的。
只需要根据以上规则，验证已经填入的数字是否有效即可。
给定数独序列只包含数字 1-9 和字符 '.' 。
给定数独永远是 9x9 形式的。
 */

package Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board1 =
        {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        char[][] board2 =
        {
            {'8','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
         };

        System.out.println(isValidSudoku(board1));
        System.out.println(isValidSudoku(board2));
    }

    public static boolean isValidSudoku(char[][] board) {
        Map<Integer,Set> rowMap = new HashMap<Integer, Set>();
        Map<Integer,Set> columnMap = new HashMap<Integer, Set>();
        Map<Integer,Set> squareMap = new HashMap<Integer, Set>();
        for(int i = 0;i < 9;i++){
            Set set1 = new HashSet();
            rowMap.put(i,set1);
            Set set2 = new HashSet();
            columnMap.put(i,set2);
            Set set3 = new HashSet();
            squareMap.put(i,set3);
        }
        for(int i = 0;i < 9;i++) {
            for (int j = 0; j < 9; j++) {
                char item = board[i][j];
                if (item != '.') {
                    if (rowMap.get(i).contains(item)) {
                        return false;
                    } else {
                        rowMap.get(i).add(item);
                    }
                    if (columnMap.get(j).contains(item)) {
                        return false;
                    } else {
                        columnMap.get(j).add(item);
                    }
                    int key = j/3+i/3*3;
                    if (squareMap.get(key).contains(item)) {
                        return false;
                    } else {
                        squareMap.get(key).add(item);
                    }
                }
            }
        }
        return true;
    }

    //大佬方法
    public boolean isValidSudoku2(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] square = new int[3][3][9];
        int data;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                data = (int) (board[i][j] - '0');
                if (data < 0) continue;
                if (rows[i][data-1]++ + columns[j][data-1]++ + square[i/3][j/3][data-1]++ > 0)
                    return false;
            }
        }
        return true;
    }

}
