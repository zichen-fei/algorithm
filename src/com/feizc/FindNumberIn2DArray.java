package com.feizc;

/**
  二维数组中的查找
  在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
  每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

 输入
 {{1, 4, 7, 11, 15},
 {2, 5, 8, 12, 19},
 {3, 6, 9, 16, 22},
 {10, 13, 14, 17, 24},
 {18, 21, 23, 26, 30}}

 输出
 给定 target = 5，返回 true
 给定 target = 20，返回 false
 */
class FindNumberIn2DArray {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 20;
        FindNumberIn2DArray f = new FindNumberIn2DArray();
        System.out.println(f.findNumberIn2DArray(matrix, target));
    }

    private boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int col = matrix[0].length;
        if (col == 0) {
            return false;
        }
//        return linearSearch(matrix, target);
        return binarySearch(matrix, target, 0, col - 1, row, col);
    }

    //二分查找
    private boolean binarySearch(int[][] matrix, int target, int row_i, int col_j, int row, int col) {
        if (row_i >= row || col_j < 0) {
            return false;
        }
        int root = matrix[row_i][col_j];
        if (root < target) {
            return binarySearch(matrix, target, row_i + 1, col_j, row, col);
        } else if (root > target) {
            return binarySearch(matrix, target, row_i, col_j - 1, row, col);
        } else {
            return true;
        }
    }

    //线性查找
    public boolean linearSearch(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n - 1;
        while (row < m && col >= 0) {
            if (matrix[row][col] > target) {
                col--;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }
}
