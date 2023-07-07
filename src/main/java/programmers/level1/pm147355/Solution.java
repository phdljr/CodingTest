package programmers.level1.pm147355;

public class Solution {
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

    public static void main(String[] args) {
        System.out.println(new Solution().solution("500000000000004566897812456574681789676878676145641689789798687454897980011111111111111111111220839878", "111111111111111111"));
    }
}
