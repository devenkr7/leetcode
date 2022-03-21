package LB400.array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class KthMaxMinElementInArray {

    public static void main(String[] args) {

        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;

        ///1. Kth smallest element

        // a. using max heap
        usingMaxHeap(arr, k);
        // b. using lomuto partition [DIDN'T WORK]
//        int answer = usingLomutoPartition(arr, 0, arr.length-1, k);
//        System.out.println(answer);

        ///2. Kth largest element
        usingMinHeap(arr, k);
        // using min heap
    }

    private static int usingLomutoPartition(int[] arr, int l, int r, int k) {
        while(l < r){
            int pIndex = randomPartition(arr, l, r);
            if(pIndex-l == k -1) return arr[pIndex];
            else if(pIndex-l > k -1){
                return usingLomutoPartition(arr, l, pIndex-1, k);
            } else {
                return usingLomutoPartition(arr, pIndex+1, r, k);
            }
        }
        return -1;
    }

    public static int partition(int[] arr, int l, int h){
         int pivot  = arr[h];
         int i = l;
         for(int j=l; j<=h-1; j++){
             if(arr[j] <= pivot) {
                 swap(arr, i, j);
                 i++;
             }
         }
         swap(arr, i+1, h);
         return i+1;
    }

     static int randomPartition(int arr[], int l, int r){
         int n = r-l+1;
         Random rd = new Random();
         int pivot = rd.nextInt(n);
         swap(arr, l + pivot, r);
         return partition(arr, l, r);
     }

    public static void swap(int[] A, int i, int j) {
         int temp = A[i];
         A[i] = A[j];
         A[j] = temp;
     }

    private static void usingMaxHeap(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int i=0;
        while(maxHeap.size() <= k && i< arr.length){
            maxHeap.add(arr[i++]);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        System.out.println(maxHeap.peek());
    }

    private static void usingMinHeap(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i=0;
        while(minHeap.size() <= k && i< arr.length){
            minHeap.add(arr[i++]);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        System.out.println(minHeap.peek());
    }
}
