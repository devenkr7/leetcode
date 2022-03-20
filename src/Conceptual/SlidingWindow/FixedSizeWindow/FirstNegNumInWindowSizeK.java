package Conceptual.SlidingWindow.FixedSizeWindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1/
public class FirstNegNumInWindowSizeK {

    public static void main(String[] args) {
        int[] arr = {12,-1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        ArrayList<Integer> result = firstNegNumInWindowSizeK(arr, k);
        System.out.println(result);
    }

    public static ArrayList<Integer> firstNegNumInWindowSizeK(int[] arr, int k){
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> negQ = new LinkedList<>(); /**/
        int i=0, j=0;
        while(j< arr.length){
            if(arr[j] < 0) {
                negQ.add(arr[j]);
            }
            if(j-i+1 < k){
                j++;//reach window size first
            } else if(j-i+1 == k){
                res.add(negQ.size() != 0 ? negQ.peek() : 0); //first element else 0
                if(negQ.size() != 0 && negQ.peek() == arr[i]){ // checking for arr[i] since we will be incrementing i
                    negQ.remove(arr[i]);
                }
                i++; j++;
            }
        }

        return res;
    }
}
