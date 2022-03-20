package Sorting;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/insertion-sort/1/#
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        int n = arr.length;
        for(int i=1; i<n; i++) {
            int temp = arr[i];
            int j =i-1;
            while(j>=0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}