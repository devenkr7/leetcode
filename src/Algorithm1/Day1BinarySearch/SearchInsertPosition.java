package Algorithm1.Day1BinarySearch;

//https://leetcode.com/problems/search-insert-position/
public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] arr = {1,4,6,7,9,13,24,46};
        int target = 5;
        System.out.println(searchInsert(arr, target));
    }

    public static int searchInsert(int[] arr, int target) {
        int start=0;
        int end = arr.length-1;

        //handle case when target is > last element of arr
        if(target> arr[arr.length-1]){
            return end+1;
        }

        while (start<=end){
            int mid = start+(end-start)/2;
            if(target<arr[mid]){ //left
                end = mid - 1;
            }
            else if(target>arr[mid]){
                start = mid + 1;
            }
            else{
                return mid;
            }
        }
        return start; /**/
    }
}
