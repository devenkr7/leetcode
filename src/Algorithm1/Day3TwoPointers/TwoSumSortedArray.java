package Algorithm1.Day3TwoPointers;

import java.util.Arrays;

//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class TwoSumSortedArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1,2,4,6,7}, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end  = nums.length-1;
        int[] res = new int[2];
        while(start < end){
            int sum = nums[start]+nums[end];
            if(sum == target){
                res[0] = start+1;
                res[1] = end+1;
                break;
            } else if(sum < target){
                start++;
            } else {
                end--;
            }
        }
        return res;
    }
}
