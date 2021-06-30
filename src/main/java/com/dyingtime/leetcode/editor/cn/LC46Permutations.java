package com.dyingtime.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 
// 👍 1425 👎 0

public class LC46Permutations {

    public static void main(String[] args) {
        Solution solution = new LC46Permutations.Solution();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }

    static
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final List<List<Integer>> results = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            int[] visited = new int[nums.length];
            backtrack(new ArrayList<>(), nums, visited);
            return results;
        }

        private void backtrack(List<Integer> list, int[] nums, int[] visited) {
            if (list.size() == nums.length) {
                results.add(new ArrayList<>(list));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (visited[i] == 1) continue;
                visited[i] = 1;
                list.add(nums[i]);
                backtrack(list, nums, visited);
                visited[i] = 0;
                list.remove(list.size() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}