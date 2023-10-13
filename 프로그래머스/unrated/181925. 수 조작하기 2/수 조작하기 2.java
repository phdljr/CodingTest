class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        int cur = numLog[0];
        for(int i=1;i<numLog.length;i++){
            int next = numLog[i];
            if(cur + 1 == next){
                answer += "w";
                cur += 1;
            } else if(cur - 1 == next){
                answer += "s";
                cur -= 1;
            } else if(cur + 10 == next){
                answer += "d";
                cur += 10;
            } else{
                answer += "a";
                cur -= 10;
            }
        }
        return answer;
    }
}