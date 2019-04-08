package com.arrays.geeksforgeeks;

public class LargestSumSubarray {

    //Kadane's Algorithm - Idea here is to find the segements/subarrays where sum is positive and find the maximum among all.
    // max_till_this_point find the positive sum
    // Does not handle negative maximum sum ( or cases when all numbers are negative)
    public static int findMaximumSum(int[] arr){
        int max_so_far = 0;
        int max_till_this_point = 0;
        int startIndex =0;
        int endIndex=0;

        for(int i=0; i< arr.length; i++) {
            max_till_this_point += arr[i];

            if(max_till_this_point < 0){
                max_till_this_point = 0;
                startIndex=i+1;
            }
            // Optimization :  - Compare only when max_till_this_point > 0 (using else if does that)
            else if(max_so_far < max_till_this_point){
                max_so_far = max_till_this_point;
                endIndex= i;
            }
        }
        System.out.println("from index "+ startIndex+" to end index "+ endIndex);
        return max_so_far;
    }

    // Following solution will work even when all the numbers are negative.
    public static int findLargestSumEvenForNegativeSum(int[] arr) {

        int max_so_far =arr[0];
        int startIndex=0;
        int endIndex=0;
        int max_till_point= arr[0];
        int s =0;

        for(int i=1; i< arr.length; i++){
            if(max_till_point + arr[i] > arr[i]) {
                max_till_point += arr[i];
            }else{
                max_till_point = arr[i];
                s = i;
            }

            if(max_so_far < max_till_point){
                max_so_far = max_till_point;
                startIndex = s;
                endIndex = i;
            }
        }
        System.out.println("start index "+ startIndex +" to end index "+ endIndex);
        return max_so_far;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2,-3,4,-1,-2,1,5,-3};

        System.out.println(LargestSumSubarray.findMaximumSum(arr));

        int[] arr2 = new int[]{-2,-4,-2,-1,-7,-8,-2,-6};
        System.out.println(LargestSumSubarray.findLargestSumEvenForNegativeSum(arr2));
    }
}
