import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = new String(s);
        String store = "";
        for(char ch: s.toCharArray()){
            if(store.indexOf(ch) == -1){
                store += ch;
            } else{
                answer = answer.replaceAll(String.valueOf(ch), "");
            }
        }
        char[] charArr = answer.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }
}