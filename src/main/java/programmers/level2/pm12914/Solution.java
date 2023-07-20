package programmers.level2.pm12914;

public class Solution {
    public long  solution(int n){
        long [] d = new long[2001];

        d[0] = 0L;
        d[1] = 1L;
        d[2] = 2L;

        for(int i=3;i<=2000;i++){
            d[i] = (d[i-1] + d[i-2]) % 1234567;
        }

        return d[n];
    }
}
