package programmers.level2.pm17680;

import java.util.*;

public class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();

        for(int i=0;i<cities.length;i++){
            if(queue.contains(cities[i].toLowerCase())){
                queue.remove(cities[i].toLowerCase());
                queue.add(cities[i].toLowerCase());
                answer += 1;
            } else{
                queue.add(cities[i].toLowerCase());
                if(queue.size() > cacheSize){
                    queue.poll();
                }
                answer+=5;
            }
        }

        return answer;
    }
}