package com.dyingtime.leetcode.editor.cn;

import com.dyingtime.leetcode.editor.cn.base.*;

import java.util.ArrayList;
import java.util.List;

import static com.dyingtime.leetcode.editor.cn.base.TreeUtils.*;
//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 538 👎 0


public class LC145BinaryTreePostorderTraversal {

    public static void main(String[] args) {
        Solution solution = new LC145BinaryTreePostorderTraversal.Solution();
    }

    static
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        private final List<Integer> results = new ArrayList<>();

        public List<Integer> postorderTraversal(TreeNode root) {
            dfs(root);
            return results;
        }

        public void dfs(TreeNode root) {
            if (root == null) return;
            dfs(root.left);
            dfs(root.right);
            results.add(root.val);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}