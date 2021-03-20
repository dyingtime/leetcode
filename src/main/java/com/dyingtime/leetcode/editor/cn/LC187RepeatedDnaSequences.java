package com.dyingtime.leetcode.editor.cn;

import com.dyingtime.leetcode.editor.cn.base.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.dyingtime.leetcode.editor.cn.base.TreeUtils.*;
import static com.dyingtime.leetcode.editor.cn.base.ArrayUtils.*;
//所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复
//序列有时会对研究非常有帮助。 
//
// 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//输出：["AAAAACCCCC","CCCCCAAAAA"]
// 
//
// 示例 2： 
//
// 
//输入：s = "AAAAAAAAAAAAA"
//输出：["AAAAAAAAAA"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 105 
// s[i] 为 'A'、'C'、'G' 或 'T' 
// 
// Related Topics 位运算 哈希表 
// 👍 150 👎 0


public class LC187RepeatedDnaSequences {

    public static void main(String[] args) {
        Solution solution = new LC187RepeatedDnaSequences.Solution();
        System.out.println(solution.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    static
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            Set<String> strings = new HashSet<>();
            Set<String> results = new HashSet<>();
            for (int i = 0; i < s.length() - 9; i++) {
                String substring = s.substring(i, i + 10);
                if (strings.contains(substring)) results.add(substring);
                else strings.add(substring);
            }
            return new ArrayList<>(results);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}