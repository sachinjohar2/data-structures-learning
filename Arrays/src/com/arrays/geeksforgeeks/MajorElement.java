package com.arrays.geeksforgeeks;

public class MajorElement {

    public static void findMajorElement(int[] arr){

        int majorElement = findCandidate(arr);

        if(isMajor(arr, majorElement)){
            System.out.println("Major Element is : "+ majorElement);
        }else{
            System.out.println("No Major element found");
        }


    }

    // Moore's voting algorithm (it can not detect whether major element exists or not)
    // It can find major element given that major element exists in array.
    // There are two phases. In first phase we find the potential major candidate and in second phase
    // we validate that given candidate is actually a major element.
    private static int findCandidate(int[] arr){
        int n = arr.length;

        int max_index =0; int count = 1;

        for(int i=1; i< n; i++){
            if(arr[max_index] == arr[i]){
                count++;
            }else{
                count--;
            }
            if(count ==0){
                max_index = i;
                count=1;
            }
        }
        return arr[max_index];
    }

    private static boolean isMajor(int[] arr, int major){
        int count = 0;
        for(int i=0; i< arr.length; i++){
            if(arr[i] == major){
                count++;
            }
        }

        if(count > arr.length / 2){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,2,6,2,4,6,3,2,2,4,2,2};

        MajorElement.findMajorElement(arr);
    }
}
