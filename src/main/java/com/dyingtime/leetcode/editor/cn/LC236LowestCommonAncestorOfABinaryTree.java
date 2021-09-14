package com.dyingtime.leetcode.editor.cn;

import com.dyingtime.leetcode.editor.cn.base.TreeNode;
import com.dyingtime.leetcode.editor.cn.base.TreeUtils;

//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], p = 1, q = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 10⁵] 内。 
// -10⁹ <= Node.val <= 10⁹ 
// 所有 Node.val 互不相同 。 
// p != q 
// p 和 q 均存在于给定的二叉树中。 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 1291 👎 0

public class LC236LowestCommonAncestorOfABinaryTree {

    public static void main(String[] args) {
        Solution solution = new LC236LowestCommonAncestorOfABinaryTree.Solution();
        TreeNode root = TreeUtils.create(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);
        root.left = p;
        root.right.left.right = q;
        solution.lowestCommonAncestor(root, p, q);
    }

    static
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // 当根节点是 p 或 q 时,根节点必然是最近公共祖先
            if (root == null || root == p || root == q) return root;
            // 递归左右子树
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            // 如果左右子树均不为null,说明 p 和 q 分别在 root 的两侧,此时 root 是LAC
            if (left != null && right != null) return root;
            // 只有左子树不为null, 说明 p 和 q 在左子树,直接返回
            // 同理,右子树不为null,直接返回右子树,右子树为null,返回null,
            // 因此可省略,直接返回右子树
            return left != null ? left : right;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}