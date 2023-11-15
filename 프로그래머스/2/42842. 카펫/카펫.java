import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        //yellow의 약수를 모아둔 배열
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        for(int i=1;i<=yellow;i++)
        {
            if(yellow%i==0) arr.add(i);
        }
        
        int num = (arr.size() % 2 == 0) ? arr.size()/2 : arr.size()/2 + 1;
        int h=0,w=0;
        for(int i=0;i<num;i++)
        {
            h = arr.get(i);
            w = arr.get(arr.size() - 1 - i);
            if((h+2)*(w+2) - h*w == brown)
            {
                answer[0] = w + 2;
                answer[1] = h + 2;
                break;
            }
        }
        
        return answer;
    }
}