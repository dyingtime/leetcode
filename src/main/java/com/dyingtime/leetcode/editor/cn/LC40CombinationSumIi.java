package com.dyingtime.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯 
// 👍 615 👎 0

public class LC40CombinationSumIi {

    public static void main(String[] args) {
        Solution solution = new LC40CombinationSumIi.Solution();
        System.out.println(solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    static
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> results = new LinkedList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            backtrack(new ArrayList<>(), candidates, 0, target);
            return results;
        }

        private void backtrack(List<Integer> list, int[] candidates, int index, int target) {
            if (target == 0) {
                results.add(new ArrayList<>(list));
                return;
            }
            for (int i = index; i < candidates.length; i++) {
                if (target - candidates[i] < 0) {
                    break;
                }
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                list.add(candidates[i]);
                backtrack(list, candidates, i + 1, target - candidates[i]);
                list.remove(list.size() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}