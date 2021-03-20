package com.dyingtime.leetcode.editor.cn;

import com.dyingtime.leetcode.editor.cn.base.*;

import java.util.HashSet;
import java.util.Set;

import static com.dyingtime.leetcode.editor.cn.base.TreeUtils.*;
import static com.dyingtime.leetcode.editor.cn.base.ArrayUtils.*;
//给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,1,3,2,5]
//输出：[3,5]
//解释：[5, 3] 也是有效的答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [-1,0]
//输出：[-1,0]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,1]
//输出：[1,0]
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 3 * 104 
// -231 <= nums[i] <= 231 - 1 
// 除两个只出现一次的整数外，nums 中的其他数字都出现两次 
// 
// Related Topics 位运算 
// 👍 373 👎 0


public class LC260SingleNumberIii {

    public static void main(String[] args) {
        Solution solution = new LC260SingleNumberIii.Solution();
        print(solution.singleNumber(new int[]{1, 2, 1, 3, 2, 5}));
    }

    static
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] singleNumber(int[] nums) {
            Set<Integer> values = new HashSet<>();
            for (int num : nums) {
                if (values.contains(num)) values.remove(num);
                else values.add(num);
            }
            return values.stream().mapToInt(Integer::intValue).toArray();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}