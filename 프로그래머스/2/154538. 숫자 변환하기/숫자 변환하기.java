import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        int[] d = new int[y+1];
        Arrays.fill(d, Integer.MAX_VALUE);
        
        d[x] = 0;
        for(int i=x;i<=y;i++){
            if(d[i] == Integer.MAX_VALUE) continue;
            if(i+n <= y){
                d[i+n] = Math.min(d[i+n], d[i]+1);
            }
            if(i*2 <= y){
                d[i*2] = Math.min(d[i*2], d[i]+1);
            }
            if(i*3 <= y){
                d[i*3] = Math.min(d[i*3], d[i]+1);
            }
        }
        
        return d[y] == Integer.MAX_VALUE ? -1 : d[y];
    }
}