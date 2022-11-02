package programmers.pm12914;

class Solution {
    static int answer = 0;
    public long solution(int n) {
        go(0, n);
        return answer;
    }

    public void go(int k, int n){
        if(k==n){
            answer++;
            return;
        }
        if(k>n) return;
        go(k+1, n);
        go(k+2, n);
    }
}