import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer;
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int i=0;i<numbers.length - 1;i++)
        {
            for(int j=i+1;j<numbers.length;j++)
            {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        ArrayList<Integer> arr = new ArrayList<Integer>(set);
        Collections.sort(arr);
        
        answer = new int[arr.size()];
        for(int i=0; i<arr.size();i++)
        {
        	answer[i] = arr.get(i);
        }
        
        return answer;
    }
}