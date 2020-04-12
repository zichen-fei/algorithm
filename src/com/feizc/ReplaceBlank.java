package com.feizc;

/**
 * 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class ReplaceBlank {

    public static void main(String[] args) {
        String s = "We are happy.";
        ReplaceBlank r = new ReplaceBlank();
        s.replace(" ", "%20");
//        s = r.replaceBlank1(s);
        s = r.replaceBlank2(s);
        System.out.println(s);
    }

    //借助辅助数组
    public String replaceBlank1(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        char c = ' ';
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    //从后往前赋值
    public String replaceBlank2(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(s);
        int numBlank = 0;
        int length = stringBuilder.length();
        for (int i = 0; i < length; i++) {
            if (stringBuilder.charAt(i) == ' ') {
                numBlank++;
            }
        }
        length = length - 1;
        int newStringLength = length + 2 * numBlank;
        stringBuilder.setLength(newStringLength + 1);
        char c = ' ';
        while (length < newStringLength) {
            c = s.charAt(length);
            if (c != ' ') {
                stringBuilder.setCharAt(newStringLength--, c);
            } else {
                stringBuilder.setCharAt(newStringLength--, '0');
                stringBuilder.setCharAt(newStringLength--, '2');
                stringBuilder.setCharAt(newStringLength--, '%');
            }
            length--;
        }
        return stringBuilder.toString();
    }
}