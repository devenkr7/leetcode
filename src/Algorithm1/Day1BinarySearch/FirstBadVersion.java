package Algorithm1.Day1BinarySearch;

//https://leetcode.com/problems/first-bad-version/
public class FirstBadVersion {

    public static void main(String[] args) {
        System.out.println(firstBadVersion(4));
    }

    public static int firstBadVersion(int n) {
        int first = 1;
        int last = n;
        while(first<last){
            int mid = first+(last-first)/2;
            if(isBadVersion(mid)){
                last = mid; /**/
            } else {
                first = mid+1;
            }
        }
        return first; /**/
    }

    public static boolean isBadVersion(int version){
        // TODO: set bad version manually
        return version == 5;
    }
}
