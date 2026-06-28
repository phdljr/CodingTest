import java.util.ArrayList;
import java.util.PriorityQueue;

class Food implements Comparable<Food> {
    int index;
    int cal;

    public Food(int index, int cal) {
        this.index = index;
        this.cal = cal;
    }

    @Override
    public int compareTo(Food o) {
        if (this.cal < o.cal) {
            return -1;
        }
        return 1;
    }
}

class Solution {
    public int solution(int[] food_times, long k) {
        long summary = 0;
        for (int i = 0; i < food_times.length; i++) {
            summary += food_times[i];
        }
        if (summary <= k) return -1;

        PriorityQueue<Food> heap = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            heap.add(new Food(i + 1, food_times[i]));
        }

        summary = 0; // 먹기 위해 사용한 시간
        long previous = 0; // 직전에 다 먹은 음식 시간
        long length = food_times.length; // 남은 음식의 개수

        // 이걸 다 돌면, 다 먹어치울 음식은 힙에서 제거된다.
        while (summary + (heap.peek().cal - previous) * length <= k){
            int now = heap.poll().cal;
            summary += (now - previous) * length;
            length--;
            previous = now;
        }

        // 남은 음식은 인덱스 기준으로 정렬
        ArrayList<Food> result = new ArrayList<>(heap);
        result.sort((f1, f2)->{
            if(f1.index < f2.index){
                return -1;
            }
            return 1;
        });

        // 기존의 시간 k에 사용한 시간 summary를 빼서 나머지를 구함
        return result.get((int)((k-summary) % length)).index;
    }
}