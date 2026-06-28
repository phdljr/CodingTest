class Solution {
    public int solution(int M, int N) {
        int answer = 0;
        int a = 0, b = 0;
        
        int min = Math.min(M, N);
        int max = Math.max(M, N);
        
        a = (min - 1) + (min * (max - 1));
        b = (max - 1) + (max * (min - 1));
        
        return Math.min(a, b);
    }
}