package com.dyingtime.leetcode.editor.cn;

import com.dyingtime.leetcode.editor.cn.base.*;

import static com.dyingtime.leetcode.editor.cn.base.TreeUtils.*;
//给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。 
//
// 
//
// 示例： 
//
// 输入：
//
//   1
//    \
//     3
//    /
//   2
//
//输出：
//1
//
//解释：
//最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
// 
//
// 
//
// 提示： 
//
// 
// 树中至少有 2 个节点。 
// 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 
//相同 
// 
// Related Topics 树 
// 👍 235 👎 0


public class LC530MinimumAbsoluteDifferenceInBst {

    public static void main(String[] args) {
        Solution solution = new LC530MinimumAbsoluteDifferenceInBst().new Solution();
        System.out.println(solution.getMinimumDifference(create(1, null, 5, 3)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        private int min = Integer.MAX_VALUE, preVal = -1;

        public int getMinimumDifference(TreeNode root) {
            traverse(root);
            return min;
        }

        public void traverse(TreeNode root) {
            if (root == null) return;

            traverse(root.left);
            if (preVal != -1) {
                min = Math.min(min, root.val - preVal);
            }
            preVal = root.val;
            traverse(root.right);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}