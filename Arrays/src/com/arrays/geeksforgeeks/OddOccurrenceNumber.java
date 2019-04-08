package com.arrays.geeksforgeeks;

public class OddOccurrenceNumber {

    //Using XOR even elements will be cancelled out and odd occurrence element will be left in result.
    public static int findOddOccurrence(int[] arr) {

        int res = arr[0];
        for(int i=1; i< arr.length; i++) {
            res ^= arr[i];

        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,5,3,3,2,4,5};

        System.out.println(OddOccurrenceNumber.findOddOccurrence(arr));
    }


}
