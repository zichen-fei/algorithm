package com.feizc;

/**
 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999

 输入: n = 1
 输出: [1,2,3,4,5,6,7,8,9]
 */
public class PrintNumbers {

    public static void main(String[] args) {
        PrintNumbers p = new PrintNumbers();
        int[] ints = p.printNumbers2(2);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + "\t");
        }
    }

    private StringBuilder sb;

    private int idx = 0;

    //大数加法
    public int[] printNumbers2(int n) {
        sb = new StringBuilder("0");
        int sz = fast_pow(10, n) - 1;
        sz = (int)Math.pow(10, n) - 1;
        int[] result = new int[sz];
        while (increment(n)) {
            result[idx] = Integer.parseInt(sb.reverse().toString());
            sb.reverse();
            idx++;
        }
        return result;
    }

    public boolean increment(int n) {
        boolean carry = false;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (carry || i == 0) {
                if (c == '9') {
                    sb.setCharAt(i, '0');
                    carry = true;
                } else {
                    sb.setCharAt(i, (char) (c + 1));
                    carry = false;
                }
            } else {
                break;
            }
        }
        if (carry) {
            sb.append("1");
        }
        return sb.length() <= n;
    }

    //快速幂
    public int[] printNumbers(int n) {
        int sz = fast_pow(10, n) - 1;
        int[] result = new int[sz];
        for (int i = 0; i < sz; i++) {
            result[i] = i + 1;
        }
        return result;
    }

    public int fast_pow(int base, int n) {
        if (n == 0) return 1;
        if (n == 1) return base;
        if (n == -1) return 1 / base;
        int ans = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                ans *= base;
            }
            n = n / 2;
            base *= base;
        }
        return ans;
    }
}
