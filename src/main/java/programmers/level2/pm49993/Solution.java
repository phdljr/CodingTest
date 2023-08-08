package programmers.level2.pm49993;

import java.util.Arrays;

public class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i=0;i<skill_trees.length;i++){
            String str = skill_trees[i].replaceAll("[^"+skill+"]", "");
            if(skill.indexOf(str) == 0){
                answer++;
            }
        }

        return answer;
    }
}