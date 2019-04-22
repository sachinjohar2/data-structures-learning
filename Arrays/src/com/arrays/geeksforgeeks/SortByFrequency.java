package com.arrays.geeksforgeeks;

import java.util.HashMap;
import java.util.Map;

public class SortByFrequency {

    //TODO -- FINISH CODE
    // Idea is to store the frequency in a map or 2d array and then sort them as per the frequency.
    // for same frequency, to maintain order, we can store indexes in another map.
    public static void sort(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< n; i++) {
            if(map.containsKey(arr[i])){
                map.put(arr[i], 1+map.get(arr[i]));
            }else{
                map.put(arr[i], 1);
            }
        }


    }
    public static void main(String[] args) {
        int[] arr = new int[]{8,2,5,6,2,5,8,8};
    }
}
