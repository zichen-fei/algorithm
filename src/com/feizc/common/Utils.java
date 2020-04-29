package com.feizc.common;

import java.util.Random;

public class Utils {

    public enum Order {
        NULL,
        DESC,
        ASC
    }

    //生成单链表
    public static ListNode createLinkList(int length, int bound, Order order) {
        Random random = new Random();
        //头插法
        ListNode head = new ListNode(random.nextInt(bound));
        boolean flag = false;
        ListNode node;
        for (int i = 0; i < length; i++) {
            int val = random.nextInt(bound);
            if (!order.equals(Order.NULL)) {
                flag = true;
            }
            while (flag) {
                if (order.equals(Order.ASC) && head.val >= val) {
                    flag = false;
                } else if (order.equals(Order.DESC) && head.val <= val) {
                    flag = false;
                } else {
                    val = random.nextInt(bound);
                }
            }
            node = new ListNode(val);
            node.next = head;
            head = node;
        }


        //尾插法
//        ListNode head = new ListNode(random.nextInt(bound));
//        boolean flag = false;
//        ListNode curr = head;
//        ListNode node;
//        for (int i = 0; i < length; i++) {
//            int val = random.nextInt(bound);
//            if (!order.equals(Order.NULL)) {
//                flag = true;
//            }
//            while (flag) {
//                if ((order.equals(Order.ASC) && head.val >= val)
//                        || (order.equals(Order.DESC) && head.val <= val)) {
//                    flag = false;
//                } else {
//                    val = random.nextInt(bound);
//                }
//            }
//            node = new ListNode(val);
//            curr.next = node;
//            curr = node;
//        }
        return head.next;
    }

    //打印链表
    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "\t");
            head = head.next;
        }
        System.out.println();
    }

    //生成数组
    public static int[] createArray(int length, int bound) {
        Random random = new Random();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            int a = random.nextInt(bound);
            nums[i] = a;
        }
        return nums;
    }

    //打印数组
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    //生成二维数组
    public static int[][] createTwoDimArray(int rowLength, int colLength, int bound) {
        int[][] nums = new int[rowLength][colLength];
        for (int i = 0; i < rowLength; i++) {
            int[] array = createArray(colLength, bound);
            nums[i] = array;
        }
        return nums;
    }

    //打印二维数组
    public static void printTwoDimArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //打印树结构
    public static void show(TreeNode root) {
        if (root == null) {
            System.out.println("EMPTY!");
        }
        // 得到树的深度
        int treeDepth = getTreeDepth(root);

        // 最后一行的宽度为2的（n - 1）次方乘3，再加1
        // 作为整个二维数组的宽度
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
        // 用一个字符串数组来存储每个位置应显示的元素
        String[][] res = new String[arrayHeight][arrayWidth];
        // 对数组进行初始化，默认为一个空格
        for (int i = 0; i < arrayHeight; i++) {
            for (int j = 0; j < arrayWidth; j++) {
                res[i][j] = " ";
            }
        }

        // 从根节点开始，递归处理整个树
        writeArray(root, 0, arrayWidth / 2, res, treeDepth);

        // 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
        for (String[] line : res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i++) {
                sb.append(line[i]);
                if (line[i].length() > 1 && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2 : line[i].length() - 1;
                }
            }
            System.out.println(sb.toString());
        }
    }

    // 用于获得树的层数
    private static int getTreeDepth(TreeNode root) {
        return root == null ? 0 : (1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right)));
    }


    private static void writeArray(TreeNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
        if (currNode == null) {
            return;
        }
        // 先将当前节点保存到二维数组中
        res[rowIndex][columnIndex] = String.valueOf(currNode.val);

        // 计算当前位于树的第几层
        int currLevel = ((rowIndex + 1) / 2);
        // 若到了最后一层，则返回
        if (currLevel == treeDepth) {
            return;
        }
        // 计算当前行到下一行，每个元素之间的间隔（下一行的列索引与当前元素的列索引之间的间隔）
        int gap = treeDepth - currLevel - 1;

        // 对左儿子进行判断，若有左儿子，则记录相应的"/"与左儿子的值
        if (currNode.left != null) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
        }

        // 对右儿子进行判断，若有右儿子，则记录相应的"\"与右儿子的值
        if (currNode.right != null) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
        }
    }
}
