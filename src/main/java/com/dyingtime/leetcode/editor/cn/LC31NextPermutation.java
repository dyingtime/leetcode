package com.dyingtime.leetcode.editor.cn;

//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 双指针 
// 👍 1193 👎 0

import java.util.Arrays;

public class LC31NextPermutation {

    public static void main(String[] args) {
        Solution solution = new LC31NextPermutation.Solution();
        solution.nextPermutation(new int[]{4, 5, 2, 6, 3, 1});
    }

    static
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            int len = nums.length;
            for (int i = len - 1; i > 0; i--) {
                if (nums[i] > nums[i - 1]) {
                    Arrays.sort(nums, i, len);
                    for (int j = i; j < len; j++) {
                        if (nums[j] > nums[i - 1]) {
                            int temp = nums[j];
                            nums[j] = nums[i - 1];
                            nums[i - 1] = temp;
                            return;
                        }
                    }
                }
            }
            Arrays.sort(nums);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}