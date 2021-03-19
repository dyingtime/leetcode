package com.dyingtime.leetcode.editor.cn;

import com.dyingtime.leetcode.editor.cn.base.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static com.dyingtime.leetcode.editor.cn.base.TreeUtils.*;
//给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。 
//
// 
//
// 示例 1： 
//
// 输入：
//    3
//   / \
//  9  20
//    /  \
//   15   7
//输出：[3, 14.5, 11]
//解释：
//第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
// 
//
// 
//
// 提示： 
//
// 
// 节点值的范围在32位有符号整数范围内。 
// 
// Related Topics 树 
// 👍 242 👎 0


public class LC637AverageOfLevelsInBinaryTree {

    public static void main(String[] args) {
        Solution solution = new LC637AverageOfLevelsInBinaryTree.Solution();
        System.out.println(solution.averageOfLevels(create(3, 9, 20, null, null, 15, 7)));
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
        public List<Double> averageOfLevels(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            List<Double> results = new ArrayList<>();
            while (!queue.isEmpty()) {
                int size = queue.size();
                double sum = 0;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    sum += node.val;
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                results.add(sum / size);
            }
            return results;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}