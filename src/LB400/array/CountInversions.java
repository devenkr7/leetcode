package LB400.array;

//https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1#
//mini extension to merge sort
public class CountInversions {

    static int count = 0;
    public static void main(String[] args) {
        int[] arr = {2,4,1,3,5};
        int N = arr.length;

//        System.out.println(bruteForce(arr, N));

        CountInversions ci = new CountInversions();
        ci.countInversion(arr);
        System.out.println(count);
    }

    // 1. Using brute force
    private static long bruteForce(int[] arr, int N) {
        int count = 0;
        for(int i = 0; i< N -1; i++){
            for(int j = i+1; j< N; j++){
                if(arr[i] > arr[j]){
                    count++;
                }
            }
        }
        return count;
    }


    // 2. Using merge sort

    public int[] countInversion(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void mergeSort(int[] nums, int l, int r) {
        if(l == r){
            return;
        }
        int mid = (l+r)/2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid+1, r);
        merge(nums, l, r, mid);
    }
    public void merge(int[] nums, int l, int r, int m){

        int n1 = m-l+1;
        int n2 = r-m;
        int[] a1 = new int[n1];
        int[] a2 = new int[n2];
        for(int i = 0; i<n1; i++) {
            a1[i] = nums[(l + i)];
        }
        for(int j = 0; j<n2; j++) {
            a2[j] = nums[(m + 1 + j)];
        }
        int i=0, j=0, k=l;
        while (i<n1 && j<n2){
            if(a1[i] <= a2[j]){
                nums[k] = a1[i];
                i++;
            } else {
                nums[k] = a2[j];
                //In merge function for merge sort, while comparing the elements,
                // if element in right array is smaller, then it is an inversion (Why..??)
                //This means that this smaller element in the original array, is behind larger elements.
                // So add the number of larger elements or elements left in the left-array, to the value of counter.
                count += n1-i;
                j++;
            }
            k++;
        }

        while (i < n1){
            nums[k] = a1[i];
            i++; k++;
        }
        while (j < n2) {
            nums[k] = a2[j];
            j++; k++;
        }
    }
}
