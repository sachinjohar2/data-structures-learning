package com.arrays.geeksforgeeks;

import java.util.Arrays;

public class CRUDUnsorted {

    public int search(int[] arr, int element){

        for(int i=0; i< arr.length; i++) {
            if(arr[i] == element){
                return i;
            }
        }
        return -1;
    }

    public int insert(int[] arr, int element, int n){
        int len = arr.length;

        if(len >= n){
            arr[n] = element;
            return n;
        }

        return -1;
    }

    public int delete(int[] arr, int element){
        int len = arr.length;
        int index = -1;
        for(int i=0; i< len; i++){
            if(arr[i] == element){
                index = i;
            }
        }

        if(index == -1){
            return index;
        }

        for(int i=index; i< len-1; i++ ){
            arr[i] = arr[i+1];
        }
        return index;
    }

    public void print(int[] arr){
        Arrays.stream(arr).forEach(System.out::print);
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[20];
        arr[0]=2;
        arr[1]=9;
        arr[2]=3;

        CRUDUnsorted crudUnsorted = new CRUDUnsorted();

        crudUnsorted.print(arr);

        System.out.println("Found 9 at index : " + crudUnsorted.search(arr, 9));
        System.out.println("Inserted 11 at index : " + crudUnsorted.insert(arr, 11, 3));
        System.out.println("Deleted 9 from index : " + crudUnsorted.delete(arr, 9));

    }
}
