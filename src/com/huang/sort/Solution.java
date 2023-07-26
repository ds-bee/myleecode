package com.huang.sort;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {7,7,2,4,3};
//        int[] ints = bubbleSort(arr);
//        int[] ints = selectionSort(arr);
        int[] ints = insertionSort(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }
    /**
     * 冒泡排序
     * @param arr
     * @return arr
     */
    public static int[] bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // Set a flag, if true, that means the loop has not been swapped,
            // that is, the sequence has been ordered, the sorting has been completed.
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    // Change flag
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return arr;
    }

    /**
     * 选择排序
     * @param arr
     * @return
     */
    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j] ){
                    int tem = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tem;
                }
            }
        }
        return arr;
    }
    public static int[] selectionSort1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

    /**
     * 插入排序 通过dug给算出来了，但是还是有些问题
     * @param arr
     * @return arr
     */
    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int record = i;
            for (int j = i - 1; j >= 0; j--) {
                if(arr[record] < arr[j]){
                    int tem  = arr[record];
                    arr[record] = arr[j ];
                    arr[j ] = tem;
                    record--;
                }else {
                    arr[j + 1] = arr[record];
                    break;
                }
            }
        }
        return arr;
    }

    /**
     * 插入排序
     * @param arr
     * @return arr
     */
    public static int[] insertionSort1(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int preIndex = i - 1;
            int current = arr[i];
            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex -= 1;
            }
            arr[preIndex + 1] = current;
        }
        return arr;
    }

}
