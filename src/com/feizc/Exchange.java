package com.feizc;

import com.feizc.common.Utils;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * [3,1,2,4] 也是正确的答案之一。
 */
public class Exchange {

    public static void main(String[] args) {
        int[] nums = Utils.createArray(10, 100);

        Exchange e = new Exchange();
        e.exchange(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
    }

    public int[] exchange(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        int temp;
        while (i < j) {
            if (nums[i] % 2 != 0) {
                i++;
            }
            if (nums[j] % 2 == 0) {
                j--;
            }
            if (i < j) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return nums;
    }
}
