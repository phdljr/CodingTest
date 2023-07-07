package programmers.level1.pm138477;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        Queue<Integer> queue = new PriorityQueue<Integer>();

        for(int i=0;i<score.length;i++){
            queue.add(score[i]);
            if(queue.size() > k){
                queue.remove();
            }
            answer[i] = queue.peek();
        }

        return answer;
    }
}
