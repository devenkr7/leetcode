package Algorithm1.Day2TwoPointers;

import java.util.Arrays;

//https://leetcode.com/problems/squares-of-a-sorted-array/
public class SquareOfSortedArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-5, -4, -1})));
    }

    public static int[] sortedSquares(int[] nums) {

        int[] res = new int[nums.length]; // return array
        int a = 0, b = 0; //b will hold negative array size
        while(b<nums.length && nums[b]<0){
            b++;
        }
        /**/
        b--;
        int x = b == nums.length-1 ? b : b+1;

        //squaring the array
        for(int j = 0; j<nums.length; j++){
            nums[j] = nums[j]*nums[j];
        }
        //reversing first half of array
        while(a<b){
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
            a++;
            b--;
        }

        // merging two sorted array
        int firstArrIndex = 0;
        int secondArrIndex = x;
        int resIndex = 0;
        while(firstArrIndex < x && secondArrIndex < nums.length) {
            if(nums[firstArrIndex] > nums[secondArrIndex]){
                res[resIndex++] = nums[secondArrIndex++];
            } else {
                res[resIndex++] = nums[firstArrIndex++];
            }
        }
        while(firstArrIndex < x){
            res[resIndex++] = nums[firstArrIndex++];
        }
        while(secondArrIndex < nums.length){
            res[resIndex++] = nums[secondArrIndex++];
        }
        return res;
    }
}
