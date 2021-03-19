package com.dyingtime.leetcode.editor.cn.base;

/**
 * @author dyingtime
 * @since 2021/3/19
 */
public class ArrayUtils {

    public static void print(int[] array) {
        StringBuilder builder = new StringBuilder("[");
        for (int number : array) {
            builder.append(number).append(", ");
        }
        builder.delete(builder.length() - 2, builder.length());
        builder.append("]");
        System.out.println(builder.toString());
    }
}
