package com.dyingtime.leetcode.editor.cn;

import com.dyingtime.leetcode.editor.cn.base.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.dyingtime.leetcode.editor.cn.base.TreeUtils.*;
//如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。 
//
// 只有给定的树是单值二叉树时，才返回 true；否则返回 false。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[1,1,1,1,1,null,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//
// 输入：[2,2,2,5,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 给定树的节点数范围是 [1, 100]。 
// 每个节点的值都是整数，范围为 [0, 99] 。 
// 
// Related Topics 树 
// 👍 72 👎 0


public class LC965UnivaluedBinaryTree {

    public static void main(String[] args) {
        Solution solution = new LC965UnivaluedBinaryTree.Solution();
        System.out.println(solution.isUnivalTree(create(2, 2, 2, 5, 2)));
    }

    static
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
        public Set<Integer> values = new HashSet<>();

        public boolean isUnivalTree(TreeNode root) {
            dfs(root);
            return values.size() == 1;
        }

        public void dfs(TreeNode root) {
            if (root == null) return;
            values.add(root.val);
            isUnivalTree(root.left);
            isUnivalTree(root.right);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}