package com.dyingtime.leetcode.editor.cn;

//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 数组 排序 
// 👍 988 👎 0

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class LC56MergeIntervals {

    public static void main(String[] args) {
        Solution solution = new LC56MergeIntervals.Solution();
        int[][] merges = solution.merge(new int[][]{new int[]{1, 3}, new int[]{2, 6}, new int[]{8, 10}, new int[]{15, 18}});
        for (int[] merge : merges) {
            System.out.println(Arrays.toString(merge));
        }
    }

    static
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
            LinkedList<int[]> merges = new LinkedList<>();
            for (int[] current : intervals) {
                if (merges.size() == 0 || merges.getLast()[1] < current[0]) {
                    merges.add(current);
                } else {
                    merges.getLast()[1] = Math.max(merges.getLast()[1], current[1]);
                }
            }
            return merges.toArray(new int[merges.size()][]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}