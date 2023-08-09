package programmers.level2.pm17684;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<26;i++){
            map.put(String.valueOf((char)('A'+i)), i+1);
        }
        int nowIndex = 27;

        List<Integer> list = new ArrayList<>();

        int start = 0;
        int len = 1;
        String now = "";
        String prev = "";
        while(len <= msg.length()){
            now = msg.substring(start, len);
            prev = msg.substring(start, len);
            while(true){
                if(map.containsKey(now) && len < msg.length()){
                    prev = now;
                    len++;
                    now = msg.substring(start, len);
                } else{
                    break;
                }
            }
            list.add(map.get(prev));
            map.put(now, nowIndex++);
            start += prev.length();
            len = start + 1;
        }

        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        new Solution().solution("KAKAO");
    }
}
