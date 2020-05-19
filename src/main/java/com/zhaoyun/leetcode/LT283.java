package com.zhaoyun.leetcode;

/**
 * 把数组中的所有 0 挪至尾部
 *
 * @author zhaoyun
 * @Date: 2020/2/8
 */
public final class LT283 {

    /**
     * 修改元素值的方式
     */
    public void moveZeroes2(int[] nums) {
        if (nums == null) return;

        int n = nums.length;

        int index = 0;
        for (int i: nums) {
            if (i != 0) {
                nums[index++] = i;
            }
        }

        while (index < n) {
            nums[index++] = 0;
        }
    }

    /**
     * 交换的方式
     */
    public void moveZeroes(int[] nums) {
        if (nums == null) return;

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                for (int j = i +1; j < n; j++) {
                    if (nums[j] != 0) {
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                        break;
                    }
                }
            }
        }
    }
}
