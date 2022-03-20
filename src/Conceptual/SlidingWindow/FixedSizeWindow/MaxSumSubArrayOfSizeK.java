package Conceptual.SlidingWindow.FixedSizeWindow;

//https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1/
public class MaxSumSubArrayOfSizeK {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,7,3,5};
        int k = 3;
        System.out.println(maxSumSubArraySizeK(arr, k));
    }

    private static int maxSumSubArraySizeK(int[] arr, int k) {
        int i=0, j=0, sum=0, maxVar = Integer.MIN_VALUE;
        // window size = j-i+1
        while(j< arr.length) {
            sum = sum + arr[j];
            if(j-i+1 < k) {
                j++; // to reach window size first
            } else if(j-i+1 == k){
                maxVar = Math.max(maxVar, sum);
                sum = sum - arr[i]; //removing first element of window
                i++; j++;
            }
        }
        return maxVar;
    }
}
