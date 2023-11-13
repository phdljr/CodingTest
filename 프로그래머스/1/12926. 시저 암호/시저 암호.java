import java.util.*;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        boolean isUpper = false;
        
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) != ' ')
            {
                if(s.charAt(i) >= 65 && s.charAt(i) <= 90) isUpper = true;
                else isUpper = false;
                
                if(isUpper == true && s.charAt(i) + n >= 97) 
                { 
                	answer += (char)(s.charAt(i) - 26 + n);
                	continue;
                }
                
                if(s.charAt(i) + n >= 65 && s.charAt(i) + n <= 90)
                	answer += (char)(s.charAt(i) + n);
                else if(s.charAt(i) + n >= 97 && s.charAt(i) + n <= 122)
                    answer += (char)(s.charAt(i) + n);
                else
                	answer += (char)(s.charAt(i) - 26 + n);
            }
            else
                answer += " ";
        }
        
        return answer;
    }
}