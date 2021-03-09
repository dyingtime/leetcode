package com.dyingtime.leetcode.editor.cn;

import com.dyingtime.leetcode.editor.cn.base.*;

import static com.dyingtime.leetcode.editor.cn.base.TreeUtils.*;
//你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。 
//
// 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。 
//
// 示例 1: 
//
// 
//输入: 二叉树: [1,2,3,4]
//       1
//     /   \
//    2     3
//   /    
//  4     
//
//输出: "1(2(4))(3)"
//
//解释: 原本将是“1(2(4)())(3())”，
//在你省略所有不必要的空括号对之后，
//它将是“1(2(4))(3)”。
// 
//
// 示例 2: 
//
// 
//输入: 二叉树: [1,2,3,null,4]
//       1
//     /   \
//    2     3
//     \  
//      4 
//
//输出: "1(2()(4))(3)"
//
//解释: 和第一个示例相似，
//除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
// 
// Related Topics 树 字符串 
// 👍 182 👎 0


public class LC606ConstructStringFromBinaryTree {

    public static void main(String[] args) {
        Solution solution = new LC606ConstructStringFromBinaryTree().new Solution();
        TreeNode root = create(1, 2, 3, null, 4);
        System.out.println(solution.tree2str(root));
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

        public String tree2str(TreeNode t) {
            if (t == null) return "";
            StringBuilder results = new StringBuilder();
            traverse(t, results);
            return results.toString();
        }

        public void traverse(TreeNode root, StringBuilder results) {
            results.append(root.val);
            if (root.left == null && root.right == null) return;

            if (root.left != null && root.right == null) {
                results.append("(");
                traverse(root.left, results);
                results.append(")");
            }

            if (root.left == null && root.right != null) {
                results.append("()");
                results.append("(");
                traverse(root.right, results);
                results.append(")");
            }

            if (root.left != null && root.right != null) {
                results.append("(");
                traverse(root.left, results);
                results.append(")");
                results.append("(");
                traverse(root.right, results);
                results.append(")");
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}