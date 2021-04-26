package com.example.algorithm.string;

import java.util.Arrays;

public class KMP {


    /**
     * 核心思想:  字符串前缀和字符串后缀匹配
     *
     */
    public int subStr(String str, String find) {
        return -1;
    }

    /**
     * 基础版
     */
    private int[] calNext(String str) {
        char[] ch = str.toCharArray();
        int i = 0;
        int j = -1;
        int[] result = new int[ch.length];
        result[0] = -1;
        while(i < ch.length - 1) {
            if(j == -1 || ch[i] == ch[j]){
                i++;
                j++;
                result[i] = j;
            } else {
                j = result[j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        System.out.println(Arrays.toString(kmp.calNext("abababcabcddd")));
    }

}
