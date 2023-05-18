package com.huang.easy.replaceSpace;

public class Solution {
    public static void main(String[] args) {
//        String str = "We are happy.";
        String str = "%20";
        String s = replaceSpace(str);
        System.out.println(s);

    }
    public static String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        int record = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == ' '){
//                chars[i] = '%';
                record++;
            }
        }
        char[] chars2 = {'%','2','0'};
        char[] chars1 = new char[chars.length + record * 2];
        int tem = 0;
        for (int i = 0; i < chars.length; i++) {
            chars1[tem] = chars[i];
            tem++;
            if(chars[i] == ' '){
                tem--;
                int i1 = 0;
//                tem++;
                while (i1 < 3){
                    chars1[tem] = chars2[i1];
                    i1++;
                    tem++;
                }
            }
        }

        return new String(chars1);
    }
}
