package com.feizc;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5}
 * 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 */
public class ValidateStackSequences {

    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] poped = {4, 5, 3, 2, 1};
        ValidateStackSequences v = new ValidateStackSequences();
        boolean b = v.validateStackSequences(pushed, poped);
//      boolean b = v.validateStackSequences2(pushed, poped);
        System.out.println(b);
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int stack = -1, pushIndex = 0;
        for (int poppedIndex = 0; poppedIndex < popped.length; poppedIndex++) {
            while (pushIndex < pushed.length && (stack < 0 || pushed[stack] != popped[poppedIndex])) {
                pushed[++stack] = pushed[pushIndex++];
            }
            if (pushed[stack] != popped[poppedIndex])
                return false;
            else
                --stack;
        }
        return true;
    }

    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.empty() && j < popped.length && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }
}
