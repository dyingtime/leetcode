package com.dyingtime.leetcode.editor.cn;

import com.dyingtime.leetcode.editor.cn.base.*;

import java.util.ArrayList;
import java.util.List;

import static com.dyingtime.leetcode.editor.cn.base.TreeUtils.*;
//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 459 👎 0


public class LC257BinaryTreePaths {

    public static void main(String[] args) {
        Solution solution = new LC257BinaryTreePaths().new Solution();
    }

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
        private final List<String> paths = new ArrayList<>();

        public List<String> binaryTreePaths(TreeNode root) {
            constructPaths(root, "");
            return paths;
        }

        public void constructPaths(TreeNode root, String path) {
            if (root != null) {
                StringBuilder buffer = new StringBuilder(path);
                buffer.append(root.val);
                if (root.left == null && root.right == null) {
                    paths.add(buffer.toString());
                } else {
                    buffer.append("->");
                    constructPaths(root.left, buffer.toString());
                    constructPaths(root.right, buffer.toString());
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}