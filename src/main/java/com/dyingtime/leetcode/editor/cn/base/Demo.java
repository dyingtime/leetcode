package com.dyingtime.leetcode.editor.cn.base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * <p>Title: Module Information</p>
 * <p>Description: Function Description</p>
 * <p>Copyright: Copyright (c) 2019</p>
 * <p>Company: ND Co., Ltd.</p>
 * <p>Create Time:2021/7/2</p>
 *
 * @author lin lihong
 */
public class Demo {
    private List<Integer> result = new ArrayList<>();

    private void order(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");

        order(node.left);
        order(node.right);
    }

    public void dfs(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    private void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll(); // Java 的 pop 写作 poll()
            result.add(node.val);

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }

        }
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        TreeNode root = TreeUtils.create(1, 2, 6, 3, 4, null, 7, null, null, null, 5, 8, 9);
        demo.order(root);

        System.out.println();

        demo.bfs(root);
        // demo.dfs(root);
        System.out.println(demo.result);

    }
}
