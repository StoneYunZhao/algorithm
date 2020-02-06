package com.zhaoyun.leetcode.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 数组 1 按照数组 2 的顺序排序
 *
 * @author zhaoyun
 * @Date: 2020/2/6
 */
public final class LT1122 {

    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};

        int[] result = new LT1122().relativeSortArray(arr1, arr2);

        System.out.println(Arrays.toString(result));
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        final int n = arr2.length;
        final Map<Integer, Integer> w = new HashMap<>(n);

        for (int i = 0; i < n; i++) {
            w.put(arr2[i], i);
        }

        mergeSort(arr1, 0, arr1.length - 1, w);

        return arr1;
    }

    private void mergeSort(int[] arr, int s, int e, Map<Integer, Integer> w) {
        if (e <= s) {
            return;
        }

        int mid = (e + s) / 2;
        mergeSort(arr, s, mid, w);
        mergeSort(arr, mid +1, e, w);

        int i = s, j = mid + 1, cur = 0;
        int[] a = new int[e - s + 1];

        while (i <= mid && j <= e) {
            if (getV(arr[i], w) >= getV(arr[j], w)) {
                a[cur++] = arr[j++];
            } else {
                a[cur++] = arr[i++];
            }
        }

        while (i <= mid) {
            a[cur++] = arr[i++];
        }

        while (j <= e) {
            a[cur++] = arr[j++];
        }

        for (cur = 0; cur < e - s + 1; cur++) {
            arr[cur + s] = a[cur];
        }
    }

    private int getV(int i, Map<Integer, Integer> w) {
        Integer v = w.get(i);
        return v == null ? i + 1000 : v;
    }
}
