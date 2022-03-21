package LB400.array;

import java.util.Arrays;

public class Sort012Array {

    // using sorting O(nlogn)
    // using counter O(n)
    // using dutch national flag algo
    public static void main(String[] args) {
        int[] arr = {0,2,0,1,1,2,1,0,2};
        int low = 0, high = arr.length-1, mid = 0;
        while(mid < high){
            switch(arr[mid]){
                case 0:
                    swap(arr, low++, mid++);
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr, mid, high--);
                    break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
