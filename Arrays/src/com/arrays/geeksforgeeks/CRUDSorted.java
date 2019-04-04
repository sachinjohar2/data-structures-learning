package com.arrays.geeksforgeeks;

public class CRUDSorted {

    //binary search
    public static int search(int[] arr, int start, int end, int element){
        while(start <= end) {

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

    public static int insert(int[] arr, int element, int n) {
        Integer index = null;
        int length = arr.length;
        if(arr[0] > element){
            index = 0;
        }

        if(arr[length-1] < element){
            index = length;
        }

        for(int i=0; i< length -1; i++){

            if(arr[i] < element  && arr[i+1] > element){
                index = i+1;
            }
        }
        if(index != null) {
            arr[index] = element;
            for (int i = index + 1; i < length -1; i++) {
                arr[i+1] =arr[i];
            }
        }


        return -1;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1,3,5,7,8,9,11,14};

        System.out.println("Found element at index " +  CRUDSorted.search(arr, 0, arr.length - 1, 14));

    }
}
