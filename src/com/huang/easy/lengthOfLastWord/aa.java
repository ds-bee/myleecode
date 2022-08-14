//package com.huang.easy.lengthOfLastWord;
//
//import javax.xml.ws.EndpointReference;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//class Solution {
//    public int lengthOfLastWord(String s) {
//        String[] buff = s.split(" ");
//
//        return buff[buff.length].length();
//
//    }
//}
//
//public class MainClass {
//    public static String stringToString(String input) {
//
//        return JsonArray.readFrom("[" + input + "]").get(0).asString();
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            String s = stringToString(line);
//
//            int ret = new Solution().lengthOfLastWord(s);
//
//            String out = String.valueOf(ret);
//
//            System.out.print(out);
//        }
//    }
//}