import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] temp = s.split(" ");
        int[] arr = new int[temp.length];
        for(int i=0;i<arr.length;i++)
        {
            arr[i] = Integer.parseInt(temp[i]);
        }
        
        Arrays.sort(arr);
        
        answer += Integer.toString(arr[0]);
        answer += " ";
        answer += Integer.toString(arr[arr.length-1]);
        
        return answer;
    }
}