package LBPlaylist;

public class CountInversions {

    public static void main(String[] args) {
        long[] arr = {1,2,3,4};
        long N = arr.length;

        System.out.println(bruteForce(arr, N));



    }

    private static long bruteForce(long[] arr, long N) {
        long count = 0L;
        for(int i = 0; i< N -1; i++){
            for(int j = i+1; j< N; j++){
                if(arr[i] > arr[j]){
                    count++;
                }
            }
        }
        return count;
    }
}
