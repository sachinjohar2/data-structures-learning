package com.arrays.geeksforgeeks;

public class MissingNumber {

    public static int findMissing(int[] arr, int n){
        int sum = n*(n+1) /2;
        int expectedSum = 0;
        for(int i=0; i< arr.length; i++){
            expectedSum +=arr[i];
        }
        return sum-expectedSum;
    }

    // Using xor for 1 to n numbers and array. All will cancel out, except missing number.
    public static int findMissingUsingXor(int[] arr, int n){
        int expected= 1;
        int k = 1;
        while( ++k <= n){
            expected ^= k;
        }
        for(int i=0; i< arr.length; i++){
            expected ^= arr[i];
        }
        return expected;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,5,3,7,8};

        System.out.println(MissingNumber.findMissing(arr, 8));

        System.out.println(MissingNumber.findMissingUsingXor(arr, 8));

    }
}
