import java.util.*;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        int temp = 0;
        for(char ch: my_string.toCharArray()){
            if('0' <= ch && ch <= '9'){
                if(temp != 0){
                    temp *= 10;
                }
                temp += ch - '0';
            } else{
                answer += temp;
                temp = 0;
            }
        }
        answer += temp;
        
        return answer;
    }
}