package com.matrix.geeksforgeeks;

public class SearchElement {

    //Simple solution using o(n2)
    public static void search(int[][] arr, int num){

        int n = arr.length;
        int m = arr[0].length;

        if(m != n)
            return;

        for(int i=0; i< n; i++){
            for(int j=0; j< n; j++){
                if(arr[i][j] == num){
                    System.out.println("Found at ("+ (i+1) +"," + (j+1)+")");
                    return;
                }
            }
        }
        System.out.println("Not Found");
    }



    public static void main(String[] args) {
        int[][] arr = new int[][]{  {2,4,6,7},
                                    {5,7,8,10},
                                    {12,14,16,18},
                                    {21,22,24,27}};

        SearchElement.search(arr,5);
    }
}
