package Sorting;

import java.util.Arrays;

//https://www.youtube.com/watch?v=9crZRd8GPWM&t=198s&ab_channel=Jenny%27slecturesCS%2FITNET%26JRF
public class ShellSort {

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {4,2,3,6,1,9,7,5};
        int n = arr.length;

        for(int gap=n/2; gap>0; gap/=2){
            for(int j = gap; j<n; j++){
                for(int i=j-gap; i>=0; i-=gap){  /* this  LOOP */

                    if(arr[i+gap] > arr[i]){
                        break;
                    } else {
                        swap(arr, i+gap, i);
                    }
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
