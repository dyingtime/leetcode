package com.dyingtime.leetcode.editor.cn;

//泰波那契序列 Tn 定义如下：
//
// T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2 
//
// 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。 
//
// 
//
// 示例 1： 
//
// 输入：n = 4
//输出：4
//解释：
//T_3 = 0 + 1 + 1 = 2
//T_4 = 1 + 1 + 2 = 4
// 
//
// 示例 2： 
//
// 输入：n = 25
//输出：1389537
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 37 
// 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。 
// 
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 76 👎 0

public class LC1137NThTribonacciNumber {

    public static void main(String[] args) {
        Solution solution = new LC1137NThTribonacciNumber.Solution();
        System.out.println(solution.tribonacci(25));
    }

    static
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int tribonacci(int n) {
            return trib(n, new int[n + 1]);
        }

        public int trib(int n, int[] mem) {
            if (n == 0) return 0;
            if (n == 1 || n == 2) return 1;
            if (mem[n] == 0) mem[n] = trib(n - 3, mem) + trib(n - 2, mem) + trib(n - 1, mem);
            return mem[n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}