package Algorithm1.Day1BinarySearch;

// https://leetcode.com/problems/binary-search/
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1,2,3,5,6,8,9,13,18};
        int target = 6;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[mid] < target)
                start = mid+1;
            else if(nums[mid] > target)
                end = mid-1;
        }
        return -1;
    }

}

