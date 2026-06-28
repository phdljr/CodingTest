class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = schedules.length;
        
        for(int i=0;i<schedules.length;i++){
            int schedule = schedules[i] + 10;
            int h = schedule / 100;
            int m = schedule % 100;
            if(m >= 60){
                m -= 60;
                h++;
            }
            schedule = h * 100 + m;
                
            int s = startday - 1;
            for(int j=0;j<7;j++){
                s = (s % 7) + 1;
                if(s == 6 || s == 7)
                    continue;
                
                int enterTime = timelogs[i][j];
                if(enterTime > schedule){
                    answer--;
                    break;
                }
            }
        }
        
        return answer;
    }
}