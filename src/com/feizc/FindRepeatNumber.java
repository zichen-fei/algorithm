package com.feizc;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中重复的数字
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 示例：
 * 输入：{2, 3, 1, 0, 2, 5, 3}
 * 输出：2 或 3
 */
public class FindRepeatNumber {
    public static void main(String[] args) {
        FindRepeatNumber f = new FindRepeatNumber();
        int[] arr = {3, 1, 2, 3};
        int a = f.findRepeatNumber1(arr);
//        int a = f.findRepeatNumber2(arr);
//        int a = f.findRepeatNumber3(arr);
        System.out.println(a);
    }

    //哈希表
    public int findRepeatNumber1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return nums[i];
            }
            map.put(nums[i], 1);
        }
        return -1;
    }

    //原地排序
    public int findRepeatNumber2(int[] nums) {
        int[] num = new int[nums.length];

        for (int j = 0; j < num.length; j++) {
            num[j] = -1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num[nums[i]]) {
                return nums[i];
            } else {
                num[nums[i]] = nums[i];
            }
        }
        return -1;
    }

    //数组排序，再找重复。时间：O(nlogn)
    public int findRepeatNumber3(int[] nums) {
        quickSort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    private void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private void quickSort(int[] a, int left, int right) {
        if (left < right) {
            int pivot = a[left];
            int lo = left;
            int hi = right;
            while (lo < hi) {
                while (lo < hi && a[hi] >= pivot) {
                    hi--;
                }
                a[lo] = a[hi];
                while (lo < hi && a[lo] <= pivot) {
                    lo++;
                }
                a[hi] = a[lo];
            }
            a[lo] = pivot;
            quickSort(a, left, lo - 1);
            quickSort(a, lo + 1, right);
        }
    }
}
