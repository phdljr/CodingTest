class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        for(int x=1;x<=r2;x++){
            double y2 = Math.sqrt(Math.pow(r2, 2) - Math.pow(x, 2));
            double y1 = x > r1 ? 0 : Math.sqrt(Math.pow(r1, 2) - Math.pow(x, 2));
            
            answer += (Math.floor(y2) - Math.ceil(y1)) + 1;
        }
        
        return answer*4;
    }
}