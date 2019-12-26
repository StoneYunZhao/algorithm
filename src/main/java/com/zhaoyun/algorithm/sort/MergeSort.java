package com.zhaoyun.algorithm.sort;

/**
 * @author zhaoyun
 * create at 2019/12/26 11:23
 */
public final class MergeSort implements Sort<Integer> {

    @Override
    public void sort(Integer[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(Integer[] nums, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = (p + r) / 2;
        mergeSort(nums, p, q);
        mergeSort(nums, q + 1, r);
        merge(nums, p, r);
    }

    private void merge(Integer[] nums, int p, int r) {
        int q = (p + r) / 2;

        int[] tmp = new int[r - p + 1];

        int i = p, j = q + 1, cur = 0;
        while (i <= q && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[cur++] = nums[i++];
            } else {
                tmp[cur++] = nums[j++];
            }
        }

        for (; i <= q; i++) {
            tmp[cur++] = nums[i];
        }

        for (; j <= r; j++) {
            tmp[cur++] = nums[j];
        }

        cur = 0;
        for (int k = p; k <= r; k++) {
            nums[k] = tmp[cur++];
        }
    }
}
