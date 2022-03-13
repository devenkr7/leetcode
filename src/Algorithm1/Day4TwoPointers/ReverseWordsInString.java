package Algorithm1.Day4TwoPointers;

//https://leetcode.com/problems/reverse-words-in-a-string-iii/
public class ReverseWordsInString {

    public static void main(String[] args) {
        String s = "this is us";
        System.out.println(reverseWords(s));
    }

    public static void reverseString(char[] s, int start, int end) {
        while(start<end){
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }
    public static String reverseWords(String s) {
        char[] c = s.toCharArray();
        int start = 0;
        for(int i = 0; i<c.length; i++) {
            if(c[i] == ' '){
                reverseString(c, start, i-1);
                start = i+1;
            }
        }
        reverseString(c, start, c.length-1);
        return String.valueOf(c);

    }
}
