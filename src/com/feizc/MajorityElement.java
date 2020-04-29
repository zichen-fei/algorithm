package com.feizc;

/**
 数组中出现次数超过一半的数字

 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 输出: 2
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        MajorityElement m = new MajorityElement();
        int i = m.majorityElement(nums);
        System.out.println(i);
    }

    public int majorityElement(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int result = 0;
        int times = 1;
        for (int i = 0; i < nums.length; i++) {
            if (times == 0) {
                result = nums[i];
                times = 1;
            } else if (nums[i] == result){
                times++;
            } else {
                times--;
            }
        }
        return result;
    }
}
