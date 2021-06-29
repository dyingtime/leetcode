package com.dyingtime.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 
// 👍 1375 👎 0

public class LC17LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        Solution solution = new LC17LetterCombinationsOfAPhoneNumber.Solution();
        System.out.println(solution.letterCombinations("23"));
    }

    static
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final String[] LETTER_MAPPING = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        private final StringBuilder sb = new StringBuilder();
        private final List<String> results = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            if (digits.length() == 0) return results;
            backtrack(digits, 0);
            return results;
        }

        public void backtrack(String digits, int index) {
            if (sb.length() == digits.length()) {
                results.add(sb.toString());
                return;
            }
            String val = LETTER_MAPPING[digits.charAt(index) - '2'];
            for (char ch : val.toCharArray()) {
                sb.append(ch);
                backtrack(digits, index + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}