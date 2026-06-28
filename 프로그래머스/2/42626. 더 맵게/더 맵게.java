import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        for(int s: scoville)
            heap.add((long)s);
            
        long min = heap.peek();
        while(heap.size() >= 2 && min < K){
            long first = heap.poll();
            long second = heap.poll();
            heap.add(first + second * 2);
            answer++;
            min = heap.peek();
        }
        
        return min < K ? -1 : answer;
    }
}