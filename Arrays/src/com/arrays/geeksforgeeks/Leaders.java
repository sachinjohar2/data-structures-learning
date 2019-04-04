package com.arrays.geeksforgeeks;

public class Leaders {

    public static void printLeaders(int[] arr){
        int len = arr.length;

        int MAX = Integer.MIN_VALUE;
        for(int i= len-1; i >=0; i--){
            if(arr[i] > MAX){
                MAX = arr[i];
                System.out.print(MAX + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{16,17,4,6,5,2,0};
        Leaders.printLeaders(arr);
    }
}
