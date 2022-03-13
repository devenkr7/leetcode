package Algorithm1.Day3TwoPointers;

import java.util.Arrays;

//https://leetcode.com/problems/move-zeroes/
public class MoveZeroes {

    public static void main(String[] args) {
        int [] nums = {1,3,0,0,4,5,0,7};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        //shifting non-zero elements forward
        int a=0;
        for(int j=0; j<nums.length; j++){
            if(nums[j]!=0){
                nums[a] = nums[j];
                a++;
            }
        }
        //filling remaining array with zeros
        for(int k = a;k<nums.length; k++){
            nums[k] = 0;
        }
    }
}
