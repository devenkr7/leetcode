package Sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        System.out.println(Arrays.toString(ms.sortArray(new int[]{7,12,1,9,6})));
    }

    public int[] sortArray(int[] nums) {
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

    // IMP: using extra space is easy, see without using extra space
    // Below method I think works but TIME complexity is MORE
    public void merge(int[] nums, int l, int r, int mid){
        for(int i=mid+1; i<=r; i++){
            for(int j=l; j<r; j++){
                if(nums[i] < nums[j]){
                    swap(nums, i, j);
                }
            }
        }
    }

    // Using extra space [CORRECT]
    public void merge2(int[] nums, int l, int r, int m){
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
