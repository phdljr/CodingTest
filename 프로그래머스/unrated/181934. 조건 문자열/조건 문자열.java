class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        if(ineq.equals(">") && n > m){
            return 1;
        } else if(ineq.equals("<") && n < m){
            return 1;
        } else if(eq.equals("=") && n == m){
            return 1;
        }
        return 0;
        
    }
}