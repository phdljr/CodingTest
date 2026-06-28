class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int count = t * m;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<count;i++){
            sb.append(Long.toString(i, n).toUpperCase());
        }
        
        for(int i=0;i<t;i++){
            answer += sb.charAt(p-1);
            p += m;
        }
        
        return answer;
    }
}