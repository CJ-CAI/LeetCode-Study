package com.cj.Top100;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 *
 * @author CJ_CA
 * @date 2023/08/30
 */
public class QuickSort {
    public static void quicksort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        sort(arr, 0, arr.length);
    }

    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int[] partition = partition(arr, left, right);
            sort(arr, left, partition[0]);
            sort(arr, partition[1] + 1, right);
        }
    }

    static Random rand=new Random();
    public static int[] partition(int[] arr, int left, int right) {
        int sample = arr[rand.nextInt(right-left)+left];
        int repeat_left = left;
        int repeat_right = right-1;
        while (left<=repeat_right){
            if(arr[left]<sample){
                swap(arr, repeat_left++, left++);
            }
            else if (arr[left]>sample ) {
                //与后面的值交换不需要left++,避免交替更大的值过来
                swap(arr,repeat_right--,left);
            }else {
                left++;
            }
        }
        return new int[]{repeat_left,repeat_right};
    }

    public static void swap(int[] arr, int left, int right) {
        if (left != right) {
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 6, 10, 2, 8,10,10,10};
        quicksort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
