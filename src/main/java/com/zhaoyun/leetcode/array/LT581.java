package com.zhaoyun.leetcode.array;

/**
 * 最短无序连续子数组
 * @author zhaoyun
 * @Date: 2020/4/20
 */
public final class LT581 {
    public static void main(String[] args) {
        new LT581().findUnsortedSubarray(new int[]{1,2,3,4});
    }

    public int findUnsortedSubarray(int[] nums) {
        assert nums != null && nums.length > 0;

        int len = nums.length;

        int[] rightMin = new int[len]; // 第 i 个元素表示原数组中第 i 个元素右边的最小元素
        int min = Integer.MAX_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            rightMin[i] = min;
            min = Math.min(min, nums[i]);
        }

        int left = 0, pre = Integer.MIN_VALUE;

        while (left < len && nums[left] >= pre && nums[left] <= rightMin[left]) {
            if (left == len - 1) {
                break;
            }
            pre = nums[left++];
        }

        int max = Integer.MIN_VALUE;
        int[] leftMax = new int[len];
        for (int i = 0; i < len; i++) {
            leftMax[i] = max;
            max = Math.max(max, nums[i]);
        }

        int right = len - 1;
        pre = Integer.MAX_VALUE;
        while (right >= 0 && nums[right] <= pre && nums[right] >= leftMax[right]) {
            if (right == 0) {
                break;
            }
            pre = nums[right--];
        }

        return right > left ? right - left + 1 : 0;
    }
}
