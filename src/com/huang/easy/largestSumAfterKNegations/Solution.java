package com.huang.easy.largestSumAfterKNegations;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
//        int[] arr = {3,-1,0,2};
//        int[] arr = {3,4,2};
        int[] arr = {-3,-4,2};
//        int[] arr = {5,6,9,-3,3};
//        int[] arr = {-8,3,-5,-3,-5,-2};
        int k = 1;
        System.out.println(largestSumAfterKNegations(arr, k));

    }

    public static int largestSumAfterKNegations1(int[] nums, int k) {
        // 排序，把可能有的负数排到前面
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 贪心：如果是负数，而k还有盈余，就把负数反过来
            if (nums[i] < 0 && k > 0) {
                nums[i] = -1 * nums[i];
                k--;
            }
            sum += nums[i];
        }
        Arrays.sort(nums);
        // 如果k没剩，那说明能转的负数都转正了，已经是最大和，返回sum
        // 如果k有剩，说明负数已经全部转正，所以如果k还剩偶数个就自己抵消掉，不用删减，如果k还剩奇数个就减掉2倍最小正数。
        return sum - (k % 2 == 0 ? 0 : 2 * nums[0]);

//        这里实现了前面负数转正，但是还剩k时，没有想到反转的算法。
    }

    public int largestSumAfterKNegationsv1(int[] nums, int K) {
        // 将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //从前向后遍历，遇到负数将其变为正数，同时K--
            if (nums[i] < 0 && K > 0) {
                nums[i] = -nums[i];
                K--;
            }
        }
        // 如果K还大于0，那么反复转变数值最小的元素，将K用完

        if (K % 2 == 1) nums[len - 1] = -nums[len - 1];
        return Arrays.stream(nums).sum();

    }

//    public static int largestSumAfterKNegations(int[] nums, int k) {
//        boolean flag = false;
//        if( k % 2 == 0){
//            flag = true;
//        }
//        Arrays.sort(nums);
//        int sum = 0;
//        int record = 0;
//        for (int i = 0; i < nums.length; i++) {
//            k--;
//            if(nums[i] < -nums[i] && k >= 0){
//                sum = sum - nums[i];
//            }else {
//                sum = sum + nums[i];
//                k--;
//            }
//
//        }
//        return sum;
//    }

    //这段代码有点把所有情况都考虑的意思，不能算出结果
    public static int largestSumAfterKNegations(int[] nums, int k) {
        boolean flag = false;
        if( k % 2 == 0){
            flag = true;
        }
        Arrays.sort(nums);
        int sum = 0;
        int record = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < 0 ){
                record++;
            }
        }
        int b = 0;
        if(record > k){
            while (b < k){
                nums[b] = -nums[b];
                b++;
            }
        }else {
            for (int i1 = 0; i1 < k; i1++) {
                if(i1 < record){
//                    if(!flag){
                    nums[i1] = -nums[i1];
//                    }
                }else {
                    if(((k - i1) % 2) == 1){
                        nums[i1] = -nums[i1];
//                        if((i1 - 1)>0  && -nums[i1] > nums[i1 - 1] ){
//                            nums[i1] = -nums[i1];
//                            nums[i1 - 1] = -nums[i1 - 1];
//                        }
                    }
                    break;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        return sum;
    }
}
