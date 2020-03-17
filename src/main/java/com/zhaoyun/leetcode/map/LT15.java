package com.zhaoyun.leetcode.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 三数之和
 *
 * @author zhaoyun
 * @Date: 2020/3/17
 */
public final class LT15 {

    /**
     * 两层循环 + HashMap
     * <p>
     * 时间复杂度 O(n^2)，空间复杂度 O(n)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }

        Arrays.sort(nums); // 排序复杂度 O(nlogn)，但是没有嵌套在主循环里面

        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            cache.put(nums[i], i);
        }

        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j];
                Integer c = cache.get(-a - b);
                if (c != null && c > j) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(a);
                    tmp.add(b);
                    tmp.add(-a - b);
                    result.add(tmp);
                }

                while (j < nums.length - 1 && nums[j + 1] == b) {
                    j++;
                }
            }
            while (i < nums.length - 1 && nums[i + 1] == a) {
                i++;
            }

        }

        return result;
    }

    /**
     * 一层循环 + 两个指针移动
     * <p>
     * 时间复杂度 O(n^2)，空间复杂度 O(1)
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);

        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                if (a + nums[j] + nums[k] == 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(a);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    result.add(tmp);

                    while (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                        j++;
                    }

                    while (k > i + 1 && nums[k] == nums[k - 1]) {
                        k--;
                    }

                    j++;
                    k--;
                } else if (a + nums[j] + nums[k] > 0) {
                    k--;
                } else {
                    j++;
                }
            }

            while (i < nums.length - 1 && nums[i + 1] == a) {
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> r = new LT15().threeSum2(test);
        System.out.println(r);
    }
}
