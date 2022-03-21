package LB400.array;

public class MaxMinInArray {

    public static void main(String[] args) {
        long[] a = {1L, 23L, 12L, 342L, 124L};
        long n = a.length;

        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        for(long i=0; i<n; i++){
            if(a[(int)i] > max){
                max = a[(int)i];
            }
            if(a[(int)i] < min){
                min = a[(int)i];
            }
        }
        System.out.println("Min element: " + min);
        System.out.println("Max element: " + max);
    }
}
