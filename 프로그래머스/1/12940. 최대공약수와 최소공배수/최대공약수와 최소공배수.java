class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        //최대공약수
        answer[0] = 1;
        for(int i=1;i<=(int)Math.min(n,m);i++)
        {
            if(n%i == 0 && m%i == 0) answer[0] = i;
        }
        
        //최소공배수
        answer[1] = answer[0] * n/answer[0] * m/answer[0];
        
        return answer;
    }
}