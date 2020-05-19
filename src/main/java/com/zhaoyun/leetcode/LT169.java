package com.zhaoyun.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 找出数组中出现次数超过一半的元素
 *
 * @author zhaoyun
 * create at 2019-08-30 20:51
 */
public final class LT169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> data = new HashMap<>();
        int target = nums.length / 2;
        for (int n: nums) {
            if (!data.containsKey(n)) {
                data.put(n, 0);
            }
            int c = data.get(n);
            if (++c > target) {
                return n;
            }
            data.put(n, c);
        }
        throw new RuntimeException();
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        int target = nums.length / 2;

        int cur = nums[0], preIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != cur) {
                if (i - preIndex > target) {
                    break;
                }
                cur = nums[i];
                preIndex = i;
            }
        }
        return cur;
    }

    /**
     * O(nlogn)
     */
    public int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * O(1)
     */
    public int majorityElement4(int[] nums) {
        int cur = nums[0], c = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == cur) {
                c++;
            } else {
                c--;
            }
            if (c == 0) {
                cur = nums[++i];
                c++;
            }
        }
        return cur;
    }
}
