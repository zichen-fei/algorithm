package com.feizc;

/**
 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：

 F(0) = 0,   F(1) = 1
 F(N) = F(N - 1) + F(N - 2), 其中 N > 1.

 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class Fib {

    public static void main(String[] args) {
        Fib f = new Fib();
        int fib = f.fib(5);
        System.out.println(fib);
    }

    //dp
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }

    //滑动窗口
    public int fib2(int n) {
        int a = 0;
        int b = 1;
        int temp;
        for (int i = 0; i < n; i++) {
            temp = a + b;
            a = b;
            b = temp % 1000000007;
        }
        return a;
    }
}
