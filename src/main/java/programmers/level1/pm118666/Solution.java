package programmers.level1.pm118666;

import java.util.HashMap;

public class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] arr = {0,3,2,1,0,1,2,3}; // 1~7번 점수
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('R', 0); map.put('C', 0); map.put('J', 0); map.put('A', 0);
        map.put('T', 0); map.put('F', 0); map.put('M', 0); map.put('N', 0);

        for(int i=0;i<survey.length;i++){
            if(choices[i] < 4){ // 앞글자
                map.replace(survey[i].charAt(0), map.get(survey[i].charAt(0)) + arr[choices[i]]);
            } else if(choices[i] > 4){ //뒷글자
                map.replace(survey[i].charAt(1), map.get(survey[i].charAt(1)) + arr[choices[i]]);
            }
        }

        if(map.get('R') >= map.get('T')){
            answer += 'R';
        } else {
            answer += 'T';
        }

        if(map.get('C') >= map.get('F')){
            answer += 'C';
        } else {
            answer += 'F';
        }

        if(map.get('J') >= map.get('M')){
            answer += 'J';
        } else {
            answer += 'M';
        }

        if(map.get('A') >= map.get('N')){
            answer += 'A';
        } else {
            answer += 'N';
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] s = {"AN", "CF", "MJ", "RT", "NA"};
        int[] c = {5, 3, 2, 7, 5};
        System.out.println(new Solution().solution(s, c));
    }
}