package com.arrays.geeksforgeeks;

import java.util.Arrays;

public class MedianForTwoSortedArrays {

    // Solution using merging two arrays into one sorted array and then finding its median
    public static void findMedian(int[] arr1, int[] arr2, int n){

        int[] arr = new int[2*n];

        int i =0;
        int j =0;
        int k =0;

        while(i < 2*n){

            if((j < n && arr1[j] <= arr2[k]) || k == n) {
                arr[i] = arr1[j];
                i++;
                j++;
            }else{
                arr[i] = arr2[k];
                i++;
                k++;
            }
        }

        Arrays.stream(arr).forEach(System.out::println);

        if(2*n %2 !=0){
            System.out.println("Median : " + arr[n]);
        }else{
            System.out.println("Median : "+ (arr[(2*n+1)/2] + arr[(2*n-1)/2]) /2);
        }
    }

    public static int findMedianOptimized(int[] arr1, int[] arr2, int n){

        if(n == 2){
            return (Math.max(arr1[0], arr2[0]) + Math.min(arr1[1], arr1[1]))/2;
        }

        int m1 = getMedian(arr1, n);
        int m2 = getMedian(arr2, n);

        if(m1 == m2){
            return m1;
        }

        if(m1 > m2){

        }
        return -1;
    }

    public static int getMedian(int[] arr, int n){
        if(n % 2 != 0){
            return arr[n/2];
        }
        return (arr[(2*n+1)/2] + arr[(2*n-1)/2]);
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,12,15,26,38};
        int[] arr2 = new int[]{2,13,17,30,45};

        MedianForTwoSortedArrays.findMedian(arr1, arr2, arr1.length);


    }

}

