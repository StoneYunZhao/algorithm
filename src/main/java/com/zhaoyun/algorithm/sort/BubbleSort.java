package com.zhaoyun.algorithm.sort;

/**
 * @author zhaoyun
 * create at 2019/11/26 16:54
 */
public final class BubbleSort implements Sort<Integer> {
    @Override
    public void sort(Integer[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            boolean exchanged = false;
            for (int j = 1; j < n - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    exchanged = true;
                    exchange(nums, j - 1, j);
                }
            }
            if (!exchanged) {
                break;
            }
        }
    }

    private void exchange(Integer[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
