package com.ruibo.demo.javatools.javabasic.tree;

import java.util.Arrays;

/**
 * 面试题39：数组中出现次数超过一半的数字
 * 题目：
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如，输入一个长度为9的数组{1，2，3，2，2，2，5，4，2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2
 */
public class Quiz39 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 3, 5, 3, 2};
        Integer res = findTarget(nums);
        System.out.println(res);
        System.out.println(findBySort(nums));

        int p = findByPartition(nums,0,nums.length-1);
        System.out.println(nums[p]);
    }



    /**
     * 通过分区进行查找
     * partition基本思想：从nums中选定一个数字后，比如n[i]，
     * 经过一次partition后，可以使得partition左侧的数字都比n[i]小，右侧的都比n[i]大。
     * 这便是partition的职责。
     * <p>
     * 故在此题的背景下
     * 只要partition等于nums.length/2或nums.length/2-1即可 该数字即为所需
     * <p>
     * 借助partition 又可以融入二分法的思想，缩小搜索范围
     *
     * 缺陷：会改变原数组
     * 时间复杂度 O(nlog(n)) ~ O(n^2)
     * @param nums
     * @return
     */
    public static Integer findByPartition(int[] nums, int low, int high) {
        // {1, 2, 3, 3, 3, 3, 5, 3, 2};
        int p = partition(nums, low, high);
        if (p < nums.length / 2) {
            //从右边找
            p = findByPartition(nums, p + 1, high);
        } else if (p> nums.length / 2) {
            //从左边找
            p = findByPartition(nums, low, p - 1);
        } else {
           //已找到
        }
        return p;
    }

    private static Integer partition(int[] nums, int low, int high) {
        int v = nums[low];//取第个
        int i = low + 1;
        int j = high;
        while (true) {
            while (nums[i] <= v) {
                i++;
                if (i == high) break;
            }
            while (nums[j] > v) {
                j--;
                if (j == low) break;
            }
            if (i < j) {
                exchange(nums, i, j);
            } else {
                exchange(nums, low, j);
                return j;
            }
        }
    }

    private static void exchange(int[] nums, int i, int j) {
        int iUsed = nums[i];
        nums[i] = nums[j];
        nums[j] = iUsed;
    }

    public static Integer findBySort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 复杂度 O(N^2)
     *
     * @param nums
     * @return
     */
    public static Integer findTarget(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Integer target = null;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int t = nums[i];
            int count = 1; //这里初始化为1 因为第一次访问这个数字时 计数为1
            for (int j = i + 1; j < length; j++) {
                if (t == nums[j]) {
                    count++;
                }
                if (count > length / 2) {
                    target = t;
                    return target;
                }
            }
        }
        return target;
    }

}
