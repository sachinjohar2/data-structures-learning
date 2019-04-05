package com.arrays.geeksforgeeks;

import java.util.HashMap;
import java.util.Map;

public class PairSumAsX {

    public static void checkPairsSum(int[] arr, int x){

        int len = arr.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< len; i++){
            if(map.containsKey(arr[i])) {
                System.out.println("("+ map.get(arr[i]) +" , "+ arr[i] +")");
            }else{
                map.put(x - arr[i], arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,5,7,8,9,2,1};

        PairSumAsX.checkPairsSum(arr, 10);
    }
}
