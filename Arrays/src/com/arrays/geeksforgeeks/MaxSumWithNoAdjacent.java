package com.arrays.geeksforgeeks;

public class MaxSumWithNoAdjacent {

    public static void findMaxSum(int[] arr) {

        int n = arr.length;

        int incl = arr[0];
        int excl = 0;
        int excl_new =0;

        for(int i=1; i< n; i++) {
            excl_new = Math.max(incl, excl);

            incl = excl+ arr[i];
            excl = excl_new;
        }

        System.out.println(Math.max(incl, excl));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,5,10,40,50,35};

        MaxSumWithNoAdjacent.findMaxSum(arr);
    }
}
