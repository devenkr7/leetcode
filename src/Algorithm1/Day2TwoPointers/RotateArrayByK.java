package Algorithm1.Day2TwoPointers;

import java.util.Arrays;

//https://leetcode.com/problems/rotate-array/
public class RotateArrayByK {

    public static void swap (int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        // when k > array length
        while(k>nums.length){
            k=k-nums.length;
        }
        if(k==nums.length){
            return;
        }
        //1. reverse  whole array
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            swap(nums, left, right);
            left++; right--;
        }

        //2. reverse both parts of array
        int i=0, j=k-1;
        while(i<j){
            swap(nums, i, j);
            i++; j--;
        }
        int a=k, b=nums.length-1;
        while(a<b){
            swap(nums, a, b);
            a++; b--;
        }
    }
}
