package com.practice.problemsolving.Hashing;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Given an array, find the most frequent element in it. If there are multiple elements that appear a maximum number of times, print any one of them.
//        Input : arr[] = {1, 3, 2, 1, 4, 1}
//        Output : 1
//        Explanation: 1 appears three times in array which is maximum frequency.
//
//        Input : arr[] = {10, 20, 10, 20, 30, 20, 20}
//        Output : 20
public class FindMostFrequestNumberInArray {

    private static int mostFrequentBrute(int[] arr, int n) {
        int maxCount = 0;
        int ele_max_frequency = 0;
        for(int i = 0 ; i < n ; i++){
            int count = 0;
            for(int j = i+1 ; j < n ; j++){
                if(arr[i] == arr[j]){
                    count++;
                }
                if(count > maxCount){
                    maxCount = count;
                    ele_max_frequency = arr[i] ;
                }
            }
        }
        return ele_max_frequency;
    }

    private static int mostFrequentBetter(int[] arr, int n) {
        Arrays.sort(arr);
        System.out.print("\n");
        int ele_max_frequency = 0;
        int cnt = 0 ;
        int maxCount = 0 ;
        for(int i = 1 ; i < n ; i++){
            if(arr[i] == arr[i - 1]){
                cnt++;
            }else cnt = 1;

            if(cnt > maxCount){
                maxCount = cnt;
                ele_max_frequency = arr[i - 1] ;

            }
        }
      return ele_max_frequency;
    }

    private static int mostFrequentOptimized(int[]arr, int n) {
       Map<Integer , Integer> m = new HashMap<Integer , Integer>() ;
       for(int i = 0 ; i < n ; i++){
           int key = arr[i];
           if(m.containsKey(key)){
               int freq = m.get(key);
               freq++;
               m.put(key , freq);
           }else m.put(key, 1);
       }
       int max_count = 0 ;
       int res = -1;
       for(Map.Entry<Integer , Integer> val: m.entrySet()){
            if(max_count < val.getValue()){
                res = val.getKey();
                max_count = val.getValue();
            }

       }
       return res;
    }
    public static void main (String[] args) {

        int arr[] = {40,50,30,40,50,30,30};
        int n = arr.length;

        System.out.println(mostFrequentBrute(arr, n));
        System.out.println(mostFrequentBetter(arr, n));
        System.out.println(mostFrequentOptimized(arr, n));
    }
}

//Approch :-
//1) Brute force :- Run two loops, take a max variable
//2) Sort the array than take mx variable
//3) Hashing use map for key and vaue

