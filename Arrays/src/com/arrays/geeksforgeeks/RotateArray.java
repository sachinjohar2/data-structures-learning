package com.arrays.geeksforgeeks;

import java.util.Arrays;

public class RotateArray {

    public static void rotate(int[] arr, int d){

        int n = arr.length;
        int[] temp = new int[d];

        int k = 0;
        // Moving first d elements into temp array
        while(k < d){
            temp[k] = arr[k];
            k++;
        }

        int m = d;
        //Now rotate remaining element
        while(d > 0){
            for(int i =d; i< n; i++){
                arr[i-1] = arr[i];
            }
            d--;
        }

        //store back the elements from temp array
        for(int i=0; i< temp.length; i++) {
            arr[n-m] = temp[i];
            m--;
        }
    }


    // Idea here is to store the first element in a temp var and then shift all remaining element to left.
    // After rotating all elements, store temp variable to last index in array. Repeat d times.
    public static void  rotateOneByOne(int[] arr, int d) {

        if(d ==0){
            return;
        }

        int n = arr.length;
        int temp = arr[0];

        while(d > 0) {
            for (int i = 1; i < n; i++) {
                arr[i-1] = arr[i];
            }
            arr[n-1] = temp;
            temp = arr[0];
            d--;
        }
    }

    //juggling algorithm for rotating array elements by d. We group the elements based on gcd of n and d. and rotate each set
    // one by one. Time Complexity - o(n) and space complexity o(1)
    public static void rotateUsingJuggling(int arr[] , int d){

        int n = arr.length;

        for(int i=0; i< gcd(n, d); i++) {
            int j = i;
            int temp = arr[i];
            while(j < n){
                int k = j+d;
                if(k >=  n)
                    k = k-n;
                if(k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }

    private static int gcd(int a, int b){
        if(b==0)
            return a;
        else
            return gcd(b, a%b);
    }

    // Reversal Algorithm for rotating array. Divide array into two parts [0,d-1] and [d,n-1]
    // First reverse [0,d-1], then reverse [d,n-1] and finally reverse [0,n-1]. resultant will be rotated one.
    public static void rotateUsingReversal(int[] arr, int d){
        int n = arr.length;
        reverseArray(arr, 0, d-1);
        reverseArray(arr, d, n-1);
        reverseArray(arr, 0, n-1);
    }

    private static void reverseArray(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
        RotateArray.rotate(arr, 2);
        //Arrays.stream(arr).forEach(System.out::println);

        int[] arr2 = new int[]{1,2,3,4,5,6};
        RotateArray.rotateOneByOne(arr2, 2);
        //Arrays.stream(arr2).forEach(System.out::println);

        int[] arr3 = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
        RotateArray.rotateUsingJuggling(arr3, 3);
        //Arrays.stream(arr3).forEach(System.out::println);

        int[] arr4 = new int[]{1,2,3,4,5,6,7};
        RotateArray.rotateUsingReversal(arr4, 3);
        Arrays.stream(arr4).forEach(System.out::println);

    }
}
