package com.arrays.geeksforgeeks;

import java.util.Arrays;

public class MergeArray {

    public static void merge(int[] dest, int[] src){
        int m = dest.length;
        int n = src.length;

        moveToEnd(dest, m);

        int i = n;
        int j=0;
        int k =0 ;

        while(k < m){

             /* Take an element from mPlusN[] if
            a) value of the picked element is smaller and we have
                not reached end of it
            b) We have reached end of N[] */
            if((i < m && src[j] >= dest[i] ) || (j ==n)){
                dest[k] = dest[i];
                i++;
                k++;
            }

            else {
                dest[k] = src[j];
                j++;
                k++;
            }
        }
        Arrays.stream(dest).forEach(System.out::println);

        
    }

    private static void moveToEnd(int[] dest, int size){

        int j = size-1;
        for(int i = size-1; i >= 0; i--){

            if(dest[i] != -1){
                dest[j] = dest[i];
                j--;
            }
        }
    }



    public static void main(String[] args) {
        int[] dest = new int[]{-1, 2, -1,-1,7,-1,10};

        int[] src = new int[]{5,8,11,12};

        MergeArray.merge(dest, src);
    }
}
