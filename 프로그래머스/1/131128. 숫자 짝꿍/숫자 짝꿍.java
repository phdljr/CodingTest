import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        // 공통된 숫자 찾기
        // 내림차순 정렬 -> 다 붙이기
        String answer = "";
        
        char[] xcharr = X.toCharArray();
        char[] ycharr = Y.toCharArray();
        StringBuilder common = new StringBuilder();
        
        Arrays.sort(xcharr);
        Arrays.sort(ycharr);
        
        int xi = 0, yi = 0;
        while(xi < xcharr.length && yi < ycharr.length){
            if(xcharr[xi] == ycharr[yi]){
                common.append(xcharr[xi]);
                xi++;
                yi++;
            } else if(xcharr[xi] > ycharr[yi]){
                yi++;
            } else{
                xi++;
            }
        }
        
        answer = common.reverse().toString();
        
        if(answer.length() == 0){
            answer = "-1";
        }
        
        if(answer.charAt(0) == '0'){
            answer = "0";
        }
        
        return answer;
    }
}