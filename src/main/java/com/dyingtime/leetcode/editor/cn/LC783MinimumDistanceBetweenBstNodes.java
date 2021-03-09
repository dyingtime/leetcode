package com.dyingtime.leetcode.editor.cn;

import com.dyingtime.leetcode.editor.cn.base.*;

import static com.dyingtime.leetcode.editor.cn.base.TreeUtils.*;
//给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。 
//
// 
//
// 示例： 
//
// 输入: root = [4,2,6,1,3,null,null]
//输出: 1
//解释:
//注意，root是树节点对象(TreeNode object)，而不是数组。
//
//给定的树 [4,2,6,1,3,null,null] 可表示为下图:
//
//          4
//        /   \
//      2      6
//     / \    
//    1   3  
//
//最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。 
//
// 
//
// 注意： 
//
// 
// 二叉树的大小范围在 2 到 100。 
// 二叉树总是有效的，每个节点的值都是整数，且不重复。 
// 本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 
//相同 
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 113 👎 0


public class LC783MinimumDistanceBetweenBstNodes {

    public static void main(String[] args) {
        Solution solution = new LC783MinimumDistanceBetweenBstNodes().new Solution();
        System.out.println(solution.minDiffInBST(create(1, null, 5, 3)));
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
        private int min = Integer.MAX_VALUE, preVal = -1;

        public int minDiffInBST(TreeNode root) {
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