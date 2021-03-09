package com.dyingtime.leetcode.editor.cn;

import com.dyingtime.leetcode.editor.cn.base.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.dyingtime.leetcode.editor.cn.base.TreeUtils.*;
//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 
// 👍 277 👎 0


public class LC501FindModeInBinarySearchTree {

    public static void main(String[] args) {
        Solution solution = new LC501FindModeInBinarySearchTree().new Solution();
        System.out.println(Arrays.toString(solution.findMode(create(1, null, 2, 2))));
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

        private final List<Integer> results = new ArrayList<>();
        private int preVal, curTimes, maxTimes;

        public int[] findMode(TreeNode root) {
            traverse(root);
            int size = results.size();
            int[] ans = new int[size];
            for (int i = 0; i < size; i++) {
                ans[i] = results.get(i);
            }
            return ans;
        }

        public void traverse(TreeNode root) {
            if (root == null) return;
            traverse(root.left);

            if (root.val == preVal) {
                curTimes++;
            } else {
                preVal = root.val;
                curTimes = 1;
            }

            if (curTimes == maxTimes) {
                results.add(root.val);
            } else if (curTimes > maxTimes) {
                results.clear();
                results.add(root.val);
                maxTimes = curTimes;
            }
            traverse(root.right);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}