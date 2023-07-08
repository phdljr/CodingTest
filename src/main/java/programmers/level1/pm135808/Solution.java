package programmers.level1.pm135808;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int solution(int k, int m, int[] score) {
        // 1~k 점수
        // m: 한 상자에 담을 사과 개수
        int answer = 0;

        Integer[] s = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(s, Comparator.reverseOrder());

        int i=0;
        int index;
        while(true){
            index = i+m-1;
            if(index >= s.length)
                break;
            answer += s[index]*m;
            i += m;
        }

        return answer;
    }
}
