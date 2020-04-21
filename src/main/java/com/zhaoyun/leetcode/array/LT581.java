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

    public int findUnsortedSubarray2(int[] nums) {
        assert nums != null && nums.length > 0;

        int len = nums.length;
        if (len == 1) {
            return 0;
        }

        // 计算左边连续递增序列范围 [0, left]
        int left = 0;
        while (left < len - 1 && nums[left] <= nums[left + 1]) {
            left++;
        }

        if (left == len - 1) {
            return 0;
        }

        // 计算范围 [left + 1, len - 1] 的最小值
        int min = nums[left + 1];
        for (int i = left + 2; i < len; i++) {
            min = Math.min(min, nums[i]);
        }

        // 找到 [0, left] 中第一个小于等于 min 的位置
        for (; left >= 0; left--) {
            if (nums[left] <= min) {
                break;
            }
        }

        // 找到右边连续递增范围 [right, len - 1]
        int right = len - 1;
        while (right > 0 && nums[right] >= nums[right - 1]) {
            right--;
        }

        int max = nums[0];
        for (int i = 1; i <= right - 1; i++) {
            max = Math.max(max, nums[i]);
        }

        for (; right < len; right++) {
            if (nums[right] >= max) {
                break;
            }
        }

        return right - left - 1;
    }

    public int findUnsortedSubarray3(int[] nums) {
        assert nums != null && nums.length > 0;

        int len = nums.length;

        int max = nums[0], min = nums[len - 1];
        int r = 0, l = len - 1;
        for (int i = 0; i < len; i++) {
            if (max > nums[i]) {
                r = i;
            } else {
                max = nums[i];
            }

            int j = len - 1 - i;
            if (min < nums[j]) {
                l = j;
            } else {
                min = nums[j];
            }
        }

        return r > l ? r - l + 1 : 0;
    }
}
