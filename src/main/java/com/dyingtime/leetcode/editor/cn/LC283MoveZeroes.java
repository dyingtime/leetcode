package com.dyingtime.leetcode.editor.cn;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 1119 👎 0

public class LC283MoveZeroes {

    public static void main(String[] args) {
        Solution solution = new LC283MoveZeroes.Solution();
    }

    static
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            // 思路：设置一个index，表示非0数的个数，循环遍历数组，
            // 如果不是0，将非0值移动到第index位置,然后index + 1
            // 遍历结束之后，index值表示为非0的个数，再次遍历，从index位置后的位置此时都应该为0
            if (nums == null || nums.length <= 1) {
                return;
            }
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[index] = nums[i];
                    index++;
                }
            }

            for (int i = index; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}