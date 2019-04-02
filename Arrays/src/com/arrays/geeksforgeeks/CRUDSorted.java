package com.arrays.geeksforgeeks;

public class CRUDSorted {

    public static int search(int[] arr, int start, int end, int element){
        while(start < end) {

            int mid = (start + end)/2;

            if(arr[mid] == element){
                return mid;
            }else if(arr[mid] < element){
                return search(arr, mid+1, end , element);
            }else{
                return search(arr, start, mid, element);
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
