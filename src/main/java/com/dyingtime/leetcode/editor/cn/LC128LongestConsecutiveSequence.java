package com.dyingtime.leetcode.editor.cn;

//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 
//
// 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 并查集 数组 哈希表 
// 👍 815 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC128LongestConsecutiveSequence {

    public static void main(String[] args) {
        Solution solution = new LC128LongestConsecutiveSequence.Solution();
        System.out.println(solution.longestConsecutive(new int[]{1, 2, 0, 1}));
    }

    static
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums.length == 0) return 0;
            Arrays.sort(nums);
            List<Integer> len = new ArrayList<>();
            len.add(1);
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1]) {
                    continue;
                }
                if (nums[i] == nums[i - 1] + 1) {
                    len.set(len.size() - 1, len.get(len.size() - 1) + 1);
                } else {
                    len.add(1);
                }
            }
            return len.stream().max(Integer::compareTo).get();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}