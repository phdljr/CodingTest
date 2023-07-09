package programmers.level1.pm140108;

public class Solution {
    public int solution(String s) {
        int answer = 0;
        char x = s.charAt(0);
        int c1=0, c2=0;
        int i = 0;
        while(i < s.length()){
            if(x == s.charAt(i)){
                c1++;
            } else{
                c2++;
            }
            i++;
            if(c1 == c2 && i < s.length()){
                answer++;
                x = s.charAt(i);
            }

            if(i == s.length()){
                answer++;
                break;
            }
        }

        return answer;
    }
}