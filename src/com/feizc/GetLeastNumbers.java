package com.feizc;

import com.feizc.common.Utils;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 */
public class GetLeastNumbers {

    public static void main(String[] args) {
        int[] array = Utils.createArray(5, 10);
        Utils.printArray(array);
        GetLeastNumbers g = new GetLeastNumbers();
        int[] leastNumbers = g.getLeastNumbers(array, 3);
        Utils.printArray(leastNumbers);
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public void quickSort(int[] arr, int start, int end) {
        if (end > start) {
            int pivot = arr[start];
            int left = start;
            int right = end;
            while (left < right) {
                while (left < right && arr[right] >= pivot) {
                    right--;
                }
                arr[left] = arr[right];
                while (left < right && arr[left] <= pivot) {
                    left++;
                }
                arr[right] = arr[left];
            }
            arr[left] = pivot;
            quickSort(arr, start, left - 1);
            quickSort(arr, left + 1, end);
        }
    }
}
