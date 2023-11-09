import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer;
        
        ArrayList<Integer> a = new ArrayList<Integer>();
        
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]%divisor == 0)
            {
                a.add(arr[i]);
            }
        }
        
        if(a.size() == 0)
        {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        
        Collections.sort(a);
        
        answer = new int[a.size()];
        
        for(int i=0;i<answer.length;i++)
        {
            answer[i] = a.get(i);
        }
        
        return answer;
    }
}