package com.feizc;

/**
 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。

 输入: 2.00000, 10
 输出: 1024.00000
 */
public class MyPow {

    public static void main(String[] args) {
        MyPow m = new MyPow();
        double v = m.myPow(2.10000, 3);
        System.out.println(v);
    }

    /**
     比如2的8次方可以写成(2^4) * (2^4) = (2^2) * (2^2) * (2^2) * (2^2) = 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2
     可以发现算出左边就知道右边。这样复杂度就由O(N)降到O(logN) 于是写了个递归，注意边界， 当n取到最小值时，
     改成n取最大值最后再乘一个x（因为最小值是-2147483648，最大值是2147483647）
     */
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        double temp = 0;
        if (n > 0) {
            temp = myPow(x, n / 2 );
            return n % 2 == 0 ? temp * temp : temp * temp * x;
        } else {
            if (n == Integer.MIN_VALUE) {
                return 1 / (myPow(x, Integer.MAX_VALUE) * x);
            } else {
                return 1 / myPow(x, Math.abs(n));
            }
        }
    }
}
