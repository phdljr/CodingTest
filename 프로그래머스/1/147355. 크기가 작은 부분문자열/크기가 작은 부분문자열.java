class Solution {
    public int solution(String t, String p) {
        int answer = 0;

        long pNum = Long.parseLong(p);
        int length = t.length() - p.length() + 1;
        for(int i=0;i<length;i++){
            long temp = Long.parseLong(t.substring(i, i+p.length()));
            if(temp <= pNum){
                answer++;
            }
        }

        return answer;
    }
}