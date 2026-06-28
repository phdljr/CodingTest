import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        List<String> answer = new ArrayList<>();
        
        int start = 0;
        int end = n;
        boolean flag = true;
        while(flag){
            if(end >= my_str.length()){
                end = my_str.length();
                flag = false;
            }
            
            String temp = my_str.substring(start, end);
            answer.add(temp);
            start += n;
            end += n;
        }
        
        return answer.toArray(String[]::new);
    }
}