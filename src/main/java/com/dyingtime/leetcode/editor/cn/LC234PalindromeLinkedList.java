package com.dyingtime.leetcode.editor.cn;

import com.dyingtime.leetcode.editor.cn.base.ListNode;

//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 
// 👍 1035 👎 0

public class LC234PalindromeLinkedList {

    public static void main(String[] args) {
        Solution solution = new LC234PalindromeLinkedList.Solution();
    }

    static
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }
            //快慢指针找中点
            ListNode slow = head, fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode left = reverse(slow.next);
            while (left != null && head != null) {
                if (left.val != head.val) {
                    return false;
                }
                left = left.next;
                head = head.next;
            }
            return true;
        }

        //翻转链表
        public ListNode reverse(ListNode head) {
            ListNode pre = null, cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}