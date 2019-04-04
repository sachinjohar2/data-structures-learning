package com.arrays.geeksforgeeks;

import java.util.Arrays;

public class ReverseArray {

    //Iterative approach
    public static void reverse(int[] arr){

        int start =0;
        int end = arr.length-1;

        while(start < end){

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    //Recursive approach
    public static void reverse(int[] arr, int start, int end){
        if(start >= end){
            return;
        }

        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        reverse(arr, ++start, --end);

    }

    public static void print(int[] arr){
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,5,7,8,9,11,2,14};

        ReverseArray.reverse(arr);
        ReverseArray.print(arr);

        ReverseArray.reverse(arr, 0, arr.length-1);
        ReverseArray.print(arr);
    }
}
