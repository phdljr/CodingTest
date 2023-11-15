import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        
        int count = 0; //배포 개수
        
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        while(count!=progresses.length)
        {
            for(int i=0;i<progresses.length;i++)
            {
                if(progresses[i] < 100)
                    progresses[i] += speeds[i];
            }
            
            int j = 0; //당일 배포 개수
            for(int i=count;i < progresses.length && progresses[i] >= 100;i++)
            {
                j++;
                count++;
            }
            
            if(j!=0) arr.add(j);
        }
        
        answer = new int[arr.size()];
        
        for(int i=0;i<answer.length;i++)
            answer[i] = arr.get(i);
        
        return answer;
    }
}