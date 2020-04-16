package com.feizc;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [4,5,6,7,8,1,2,3] 为 [1,2,3,4,5,6,7,8] 的一个旋转，该数组的最小值为1。 
 */
public class MinArray {

    public static void main(String[] args) {
        int[] numbers = {4, 5, 6, 7, 8, 1, 2, 3};
        MinArray m = new MinArray();
//        int i = m.minArray2(numbers);
        int i = m.minArray3(numbers, 0, numbers.length - 1, numbers[0]);
        System.out.println(i);
    }

    public int minArray(int[] numbers) {
        int minNum = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (minNum > numbers[i]) {
                minNum = numbers[i];
            }
        }
        return minNum;
    }

    public int minArray2(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) {
                i = m + 1;
            } else if (numbers[m] < numbers[j]) {
                j = m;
            } else {
                j--;
            }
        }
        return numbers[i];
    }

    //递归
    public int minArray3(int[] numbers, int left, int right, int val) {
        if (left >= right) {
            return Math.min(numbers[left], val);
        }
        int mid = left + (right - left) / 2;
        if (numbers[mid] > numbers[left]) {
            return minArray3(numbers, mid + 1, right, val);
        } else if (numbers[mid] < numbers[left]) {
            return minArray3(numbers, left, mid, val);
        } else {
            return Math.min(minArray3(numbers, left, mid, val), minArray3(numbers, mid + 1, right, val));
        }
    }
}
