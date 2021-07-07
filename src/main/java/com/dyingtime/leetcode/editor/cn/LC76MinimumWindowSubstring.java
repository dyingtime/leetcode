package com.dyingtime.leetcode.editor.cn;

//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 
// 👍 1227 👎 0

import java.util.HashMap;

public class LC76MinimumWindowSubstring {

    public static void main(String[] args) {
        Solution solution = new LC76MinimumWindowSubstring.Solution();
    }

    static
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            HashMap<Character, Integer> need = new HashMap<>();
            HashMap<Character, Integer> window = new HashMap<>();
            for (char c : t.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }
            int start = 0, len = Integer.MAX_VALUE;
            int left = 0, right = 0, valid = 0;
            while (right < s.length()) {
                char c = s.charAt(right);
                right++;
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (need.get(c).intValue() == window.get(c).intValue()) valid++;
                }
                while (valid == need.size()) {
                    if (right - left < len) {
                        start = left;
                        len = right - left;
                    }
                    char x = s.charAt(left);
                    left++;
                    if (need.containsKey(x)) {
                        if (need.get(x).intValue() == window.get(x).intValue()) valid--;
                        window.put(x, window.get(x) - 1);
                    }
                }
            }
            return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}