package com.dyingtime.leetcode.editor.cn;

//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SE
//E"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 
// 👍 944 👎 0

public class LC79WordSearch {

    public static void main(String[] args) {
        Solution solution = new LC79WordSearch.Solution();
    }

    static
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private boolean exist = false;

        public boolean exist(char[][] board, String word) {
            int m = board.length, n = board[0].length;
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    backtrace(board, word, visited, i, j, 0);
                }
            }
            return exist;
        }

        private void backtrace(char[][] board, String word, boolean[][] visited, int i, int j, int pos) {
            int m = board.length, n = board[0].length;
            if (i < 0 || i >= m || j < 0 || j >= n || exist || visited[i][j] || board[i][j] != word.charAt(pos)) {
                return;
            }
            if (pos == word.length() - 1) {
                exist = true;
                return;
            }

            visited[i][j] = true;
            backtrace(board, word, visited, i + 1, j, pos + 1);
            backtrace(board, word, visited, i - 1, j, pos + 1);
            backtrace(board, word, visited, i, j + 1, pos + 1);
            backtrace(board, word, visited, i, j - 1, pos + 1);
            visited[i][j] = false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}