package com.zhaoyun.algorithm.sort;

import java.util.Arrays;

/**
 * @author zhaoyun
 * create at 2019/11/26 16:54
 */
public final class SortTest {

    public static void main(String[] args) {
//        Sort<Integer> sort = new QuickSort();
//        Sort<Integer> sort = new BubbleSort();
//        Sort<Integer> sort = new InsertionSort();
//        Sort<Integer> sort = new SelectionSort();
        Sort<Integer> sort = new MergeSort();

        Integer[] nums = new Integer[]{3, 4, 5, 1, 7, 3, 8, 9, 3, 10};
        sort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
