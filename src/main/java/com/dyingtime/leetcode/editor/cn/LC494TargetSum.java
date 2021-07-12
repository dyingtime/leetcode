package com.dyingtime.leetcode.editor.cn;

//给你一个整数数组 nums 和一个整数 target 。
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
// Related Topics 数组 动态规划 回溯 
// 👍 825 👎 0

public class LC494TargetSum {

    public static void main(String[] args) {
        Solution solution = new LC494TargetSum.Solution();
        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    static
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * sum(P) 前面符号为+的集合；sum(N) 前面符号为减号的集合
         * 所以题目可以转化为
         * sum(P) - sum(N) = target
         * => sum(nums) + sum(P) - sum(N) = target + sum(nums)
         * => 2 * sum(P) = target + sum(nums)
         * => sum(P) = (target + sum(nums)) / 2
         * 因此题目转化为01背包，也就是能组合成容量为sum(P)的方式有多少种
         */
        public int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum < target || (sum + target) % 2 == 1) {
                return 0;
            }
            int n = nums.length, p = (sum + target) / 2;
            int[][] dp = new int[n + 1][p + 1];
            dp[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                int num = nums[i - 1];
                for (int j = 0; j <= p; j++) {
                    if (j >= num) {
                        // 两种选择的结果之和
                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - num];
                    } else {
                        // 背包的空间不足，只能选择不装物品 i
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[n][p];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}