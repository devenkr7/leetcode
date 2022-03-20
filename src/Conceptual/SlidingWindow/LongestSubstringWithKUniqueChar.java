package Conceptual.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

//https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1/
public class LongestSubstringWithKUniqueChar {

    public static void main(String[] args) {
        String s = "aabacbebebe";
        char[] c = s.toCharArray();
        int k = 3;

        Map<Character, Integer> map = new HashMap<>();
        int i=0, j=0, result=0;

        while(j < c.length) {
            map.put(c[j], map.getOrDefault(c[j], 0) + 1); /**/

            if(map.size() < k){
                j++; // map key will be unique, hence increasing j until size = k
            } else if(map.size() == k){
                if(j-i+1 > result){
                    result = j-i+1;
                }
                j++;
            } else { // map.size > k
                while(map.size() > k){
                    if(map.containsKey(c[i])){
                        int x = map.get(c[i]);
                        if(x!=1){
                            map.put(c[i], x-1);
                        } else { // x=0 , so count is zero, we should remove this element from map
                            map.remove(c[i]);// removing element at i from the map
                        }
                    }
                    i++;
                }
                 j++;
            }
        }

        System.out.println(result == 0 ? -1 : result);
    }
}
