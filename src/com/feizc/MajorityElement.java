package com.feizc;

/**
 * 数组中出现次数超过一半的数字
 * <p>
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        MajorityElement m = new MajorityElement();
        int i = m.majorityElement(nums);
        System.out.println(i);
    }

    public int majorityElement(int[] nums) {
        int target = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (target == nums[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                target = nums[i];
                count = 1;
            }
        }
        return target;
    }
}
