package programmers.level2.pm84512check;

import java.util.ArrayList;

public class Solution {
    static int count = 0;
    static String[] dic = {"A", "E", "I", "O", "U"};
    static boolean find = false;

    public int solution(String word) {
        dfs(word, "");
        return count;
    }

    public void dfs(String answer, String word){
        if(find == true){
            return;
        }

        if(answer.equals(word)){
            find = true;
            return;
        }

        count++;
        if(word.length() < 5 && !word.equals(answer)){
            for(int i=0;i<dic.length;i++)
                dfs(answer, word + dic[i]);
        }
    }
}