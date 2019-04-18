package com.arrays.geeksforgeeks;

public class SearchInSortedNRotatedArray {

    // Idea is to find the pivot element and call binary search on two arrays
    public static int search(int[] arr, int n) {
        int pivotIndex = findPivot(arr, 0, arr.length - 1);

        if (pivotIndex == -1) {
            return binarySearch(arr, 0, arr.length - 1, n);
        }

        if (arr[pivotIndex] == n) {
            return pivotIndex;
        }

        if (arr[pivotIndex] <= n) {
            return binarySearch(arr, 0, pivotIndex - 1, n);
        }
            return binarySearch(arr, pivotIndex+1, arr.length-1, n);

    }

    private static int findPivot(int[] arr, int start, int end) {
        if (start == end)
            return start;
        if (end < start)
            return -1;

        int mid = (start + end) / 2;

        if (arr[mid + 1] < arr[mid] && end > mid) {
            return mid;
        }

        if (mid > start && arr[mid] < arr[mid - 1]) {
            return mid - 1;
        }

        if (arr[start] >= arr[mid]) {
            return findPivot(arr, start, mid - 1);
        }

        return findPivot(arr, mid + 1, end);
    }

    private static int binarySearch(int[] arr, int startIndex, int endIndex, int n) {
        if(endIndex < startIndex){
            return -1;
        }

        int mid = (startIndex + endIndex) / 2;

        if (arr[mid] == n) {
            return mid;
        }
        if (arr[mid] < n) {
            return binarySearch(arr, mid + 1, endIndex, n);
        }
        return binarySearch(arr, startIndex, mid-1, n);

    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 4, 5, 1, 2};

        System.out.println(SearchInSortedNRotatedArray.search(arr, 4));
    }
}
