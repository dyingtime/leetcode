package com.dyingtime.leetcode.editor.cn;

import com.dyingtime.leetcode.editor.cn.base.*;

import static com.dyingtime.leetcode.editor.cn.base.TreeUtils.*;
import static com.dyingtime.leetcode.editor.cn.base.ArrayUtils.*;
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 1212 👎 0


public class LC200NumberOfIslands {

    public static void main(String[] args) {
        Solution solution = new LC200NumberOfIslands.Solution();
        System.out.println(solution.numIslands(new char[][]{
        new char[]{'1', '1', '0', '0', '0'},
        new char[]{'1', '1', '0', '0', '0'},
        new char[]{'0', '0', '1', '0', '0'},
        new char[]{'0', '0', '0', '1', '1'},
        }));
    }

    static
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            int row = grid.length, col = grid[0].length;
            boolean[][] visited = new boolean[row][col];
            int result = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1' && !visited[i][j]) {
                        traverse(grid, visited, i, j);
                        result++;
                    }
                }
            }
            return result;
        }

        private void traverse(char[][] grid, boolean[][] visited, int row, int col) {
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0' || visited[row][col])
                return;

            visited[row][col] = true;
            traverse(grid, visited, row + 1, col);
            traverse(grid, visited, row - 1, col);
            traverse(grid, visited, row, col + 1);
            traverse(grid, visited, row, col - 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}