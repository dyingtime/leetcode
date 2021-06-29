package com.dyingtime.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 排序 
// 👍 3453 👎 0

public class LC15ThreeSum {

    public static void main(String[] args) {
        Solution solution = new LC15ThreeSum.Solution();
        System.out.println(solution.threeSum(new int[]{3, 0, -2, -1, 1, 2}));
    }

    static
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> results = new ArrayList<>();
            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > 0) return results;

                if (i > 0 && nums[i] == nums[i - 1]) continue;

                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right] + nums[i];

                    if (sum == 0) {
                        results.add(Arrays.asList(nums[left], nums[i], nums[right]));
                        while (left < right && nums[left + 1] == nums[left]) { ++left; }
                        while (left < right && nums[right - 1] == nums[right]) { --right; }
                        ++left;
                        --right;
                    } else if (sum > 0) {
                        --right;
                    } else {
                        ++left;
                    }
                }

            }
            return results;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}