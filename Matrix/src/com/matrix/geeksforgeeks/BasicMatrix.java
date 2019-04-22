package com.matrix.geeksforgeeks;

public class BasicMatrix {

    public static void main(String[] args) {
        int[][] arr = new int[3][3];

        // i is for row - it moves horizontally
        for(int i=0; i<3; i++){
            //j is for column - it moves vertically
            for(int j=0; j<3; j++){
                 arr[i][j] = i;
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }

    }
}
