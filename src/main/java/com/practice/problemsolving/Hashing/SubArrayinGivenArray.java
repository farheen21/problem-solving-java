package com.practice.problemsolving.Hashing;

import java.util.HashSet;
import java.util.Set;

public class SubArrayinGivenArray {
    public static boolean isSubset(int[] arr1, int[] arr2, int m, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr2[i] == arr1[j]) break;
                if (j == m) return false;
            }
        }
        return true;
    }

    private static boolean isSubsetOptimize(int[] arr1, int[] arr2, int m, int n) {
        Set<Integer> s = new HashSet<Integer>();

        for(int c : arr1){
            s.add(c);
        }
        int z = s.size();
        for(int a : arr2){
            s.add(a);
        }

        if(s.size() == z) {
            return true;
        }
        else return false;
    }
    public static void main(String args[])
    {
        int arr1[] = { 11, 1, 13, 21, 3, 7 };
        int arr2[] = { 11, 4 , 7, 1 };

        int m = arr1.length;
        int n = arr2.length;

        if (isSubset(arr1, arr2, m, n))
            System.out.print("arr2[] is "
                    + "subset of arr1[] ");
        else
            System.out.print("arr2[] is "
                    + "not a subset of arr1[]");
        System.out.println("\n");
        if (isSubsetOptimize(arr1, arr2, m, n))
            System.out.print("arr2[] is "
                    + "subset of arr1[] ");
        else
            System.out.print("arr2[] is "
                    + "not a subset of arr1[]");
    }

}

