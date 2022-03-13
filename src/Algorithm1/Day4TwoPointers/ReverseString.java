package Algorithm1.Day4TwoPointers;

import java.util.Arrays;

//https://leetcode.com/problems/reverse-string/
public class ReverseString {

    public static void main(String[] args) {
        char[] input = {'a','p','p','l','e'};
        reverseString(input);
        System.out.println(Arrays.toString(input));
    }

    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length-1;
        while(start<end){
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }
}
