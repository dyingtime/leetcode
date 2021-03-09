package com.dyingtime.leetcode.editor.cn;

import com.dyingtime.leetcode.editor.cn.base.TreeNode;

import static com.dyingtime.leetcode.editor.cn.base.TreeUtils.create;
//计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 
// 👍 289 👎 0


public class LC404SumOfLeftLeaves {

    public static void main(String[] args) {
        Solution solution = new LC404SumOfLeftLeaves().new Solution();
        TreeNode root = create(3, 9, 20, null, null, 15, 7);
        System.out.println(solution.dfs(root));
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
        public int sumOfLeftLeaves(TreeNode root) {
            return root != null ? dfs(root) : 0;
        }

        public int dfs(TreeNode node) {
            int ans = 0;
            if (node.left != null) {
                ans += isLeafNode(node.left) ? node.left.val : dfs(node.left);
            }
            if (node.right != null && !isLeafNode(node.right)) {
                ans += dfs(node.right);
            }
            return ans;
        }

        public boolean isLeafNode(TreeNode node) {
            return node.left == null && node.right == null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}