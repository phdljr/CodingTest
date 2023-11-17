class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        String[] ds = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] m = {31,29,31,30,31,30,31,31,30,31,30,31};
        int day = 0;
        
        for(int i=0;i<a - 1;i++)
        {
            day += m[i];
        }
        day += b-1;
        
        answer += ds[day%7];
        
        return answer;
    }
}