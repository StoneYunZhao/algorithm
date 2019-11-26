package com.zhaoyun.algorithm.sort;

import java.util.Arrays;

/**
 * Created by ZhaoYun on 2019-05-23
 **/
public final class QuickSort implements Sort<Integer> {

    @Override
    public void sort(Integer[] nums) {
        _sort(nums, 0, nums.length - 1);
    }

    private void _sort(Integer[] nums, int p, int q) {
        if (p >= q) {
            return;
        }

        int r = partition(nums, p, q);
        _sort(nums, p, r - 1);
        _sort(nums, r + 1, q);
    }


    private int partition(Integer[] nums, int p, int q) {
        int i = p;
        int pivot = nums[q];

        for (int j = p; j < q; j++) {
            if (nums[j] < pivot) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i++] = tmp;
            }
        }

        nums[q] = nums[i];
        nums[i] = pivot;
        return i;
    }
}
