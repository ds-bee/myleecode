package com.huang.medium.eraseOverlapIntervals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class Solution {
    /**
     * public int eraseOverlapIntervals(int[][] intervals) {
     * //这一题用贪心的原因在于每一次我们都贪心的选择右边界小的的范围（在有限的边界内，右边界小的放的个数多，那么删除的就少）
     *         //特判
     *         if(intervals.length==0) return -1;
     *         Arrays.sort(intervals,new Comparator<int[]>(){
     *             public int compare(int []com1,int []com2){
     *                 return com1[1]-com2[1];
     *             }
     *         });
     *         //按右边界来排序，实际上这一步是贪心算法的关键，因为排序过后才能从低到高依次选择
     *         int ans=1;
     *         //必选的是第一位的
     *         int right=intervals[0][1];
     *         for(int i=1;i<intervals.length;++i){
     *             if(intervals[i][0]>=right){
     *                 ans++;
     *                 right=intervals[i][1];
     *             }
     *         }
     *         return intervals.length-ans;
     *     }
     *
     * @param intervals
     * @return
     */

    public int eraseOverlapIntervals(int[][] intervals) {
        HashMap<Integer, int[]> integerHashMap = new HashMap<>();
        ArrayList<Integer> lists = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int distance = intervals[i][1] - intervals[i][0];
            int[] ints = {intervals[i][0],intervals[i][1]};
            lists.add(distance);
            integerHashMap.put(distance,ints);
        }
        Collections.sort(lists);





        int length = intervals[0].length;
        return 1;
    }
}
