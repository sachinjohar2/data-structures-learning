package com.arrays.geeksforgeeks;

public class MaxSumWithNoAdjacent {

    public static void findMaxSum(int[] arr) {

        int n = arr.length;

        int incl = arr[0];
        int excl = 0;

        for(int i=1; i< n; i++) {
            excl = Math.max(incl, excl);
            incl = Math.max(excl, arr[i]);
        }

        System.out.println(Math.max(incl, excl));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,5,10,40,50,35};

        MaxSumWithNoAdjacent.findMaxSum(arr);
    }
}
