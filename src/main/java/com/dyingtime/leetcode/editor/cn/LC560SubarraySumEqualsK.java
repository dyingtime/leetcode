package com.dyingtime.leetcode.editor.cn;

//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
// 
//
// 说明 : 
//
// 
// 数组的长度为 [1, 20,000]。 
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。 
// 
// Related Topics 数组 哈希表 前缀和 
// 👍 995 👎 0

public class LC560SubarraySumEqualsK {

    public static void main(String[] args) {
        Solution solution = new LC560SubarraySumEqualsK.Solution();
        System.out.println(solution.subarraySum(new int[]{28, 54, 7, -70, 22, 65, -6}, 100));
    }

    static
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int len = nums.length;
            int count = 0;
            for (int i = 0; i < len; i++) {
                int target = k - nums[i];
                if (target == 0) {
                    count++;
                }
                for (int j = i + 1; j < len; j++) {
                    target -= nums[j];
                    if (target == 0) count++;
                }
            }
            return count;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}