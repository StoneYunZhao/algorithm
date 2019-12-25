package com.zhaoyun.algorithm.sort;

/**
 * @author zhaoyun
 * create at 2019/12/25 19:09
 */
public final class InsertionSort implements Sort<Integer> {
    @Override
    public void sort(Integer[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int tmp = nums[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (tmp < nums[j]) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = tmp;
        }
    }
}
