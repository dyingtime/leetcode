package com.dyingtime.leetcode.editor.cn;

import com.dyingtime.leetcode.editor.cn.base.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.dyingtime.leetcode.editor.cn.base.TreeUtils.*;
//给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一
//个。 
//
// 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。 
//
// 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,2,5,null,null,5,7]
//输出：5
//解释：最小的值是 2 ，第二小的值是 5 。
// 
//
// 示例 2： 
//
// 
//输入：root = [2,2,2]
//输出：-1
//解释：最小的值是 2, 但是不存在第二小的值。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 25] 内 
// 1 <= Node.val <= 231 - 1 
// 对于树中每个节点 root.val == min(root.left.val, root.right.val) 
// 
// Related Topics 树 
// 👍 139 👎 0


public class LC671SecondMinimumNodeInABinaryTree {

    public static void main(String[] args) {
        Solution solution = new LC671SecondMinimumNodeInABinaryTree().new Solution();
        System.out.println(solution.findSecondMinimumValue(create(5, 8, 5)));
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

        public int findSecondMinimumValue(TreeNode root) {
            return traversal(root, root.val);
        }

        private int traversal(TreeNode root, int value) {
            if (root == null) return -1;
            if (root.val > value) return root.val;
            // 寻找左右子节点中，第一个大于自己的节点
            int left = traversal(root.left, value);
            int right = traversal(root.right, value);

            if (left == -1) return right;
            if (right == -1) return left;
            return Math.min(left, right);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}