import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        char[] arr = my_string.toCharArray();
        for(int n: indices){
            arr[n] = ' ';
        }
        return new String(arr).replaceAll(" ", "");
    }
}