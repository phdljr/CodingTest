package programmers.level2.pm64065;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int[] solution(String s) {
        String[] sarr = s.substring(2, s.length()-2).replaceAll("},\\{", "-").split("-");
        Arrays.sort(sarr, (o1, o2) -> o1.length() < o2.length() ? -1 : 1);

        ArrayList<Integer> answer = new ArrayList<>();

        for(String s1: sarr){
            String[] sa = s1.split(",");
            for(String t: sa){
                if(!answer.contains(Integer.parseInt(t))){
                    answer.add(Integer.parseInt(t));
                }
            }
        }

        return answer.stream().mapToInt(x->x).toArray();
    }
}
