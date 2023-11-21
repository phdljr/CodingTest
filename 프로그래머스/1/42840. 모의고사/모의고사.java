import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] name = {1,2,3};
        int[] check = {0,0,0};
        
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] thr = {3,3,1,1,2,2,4,4,5,5};
        
        for(int i=0;i<answers.length;i++)
        {
            if(one[i%5] == answers[i]) check[0]++;
            if(two[i%8] == answers[i]) check[1]++;
            if(thr[i%10] == answers[i]) check[2]++;
        }
        
        sort(name, check);
        
        int[] answer;
        if(check[0] == check[1] && check[1] == check[2])
        {
            answer = new int[3];
            answer[0] = 1;
            answer[1] = 2;
            answer[2] = 3;
        }
        else if(check[1] == check[2])
        {
            answer = new int[2];
            answer[0] = name[1];
            answer[1] = name[2];
        }
        else
        {
            answer = new int[1];
            answer[0] = name[2];
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
    
    public void sort(int[] name, int[] check)
    {
        for(int i=0;i<check.length-1;i++)
        {
            for(int j=0;j<check.length - i - 1;j++)
            {
                if(check[j] > check[j+1])
                {
                    swap(name,j,j+1);
                    swap(check,j,j+1);
                }
            }
        }
    }
    
    public void swap(int[] arr, int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}