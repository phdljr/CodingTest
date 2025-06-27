import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        // 시소 비율 후보 (좌: 거리1, 우: 거리2)
        int[][] ratios = {
            {1, 1},  // 1:1
            {2, 3},  // 2:3
            {2, 4},  // 1:2
            {3, 2},  // 3:2
            {3, 4},  // 3:4
            {4, 2},  // 2:1
            {4, 3}   // 4:3
        };

        for (int w : weights) {
            // 이미 나온 weight들과의 짝꿍 계산
            for (int[] r : ratios) {
                int left = w * r[0];
                int right = r[1];

                if (left % right != 0) continue;

                int pairWeight = left / right;
                answer += map.getOrDefault(pairWeight, 0);
            }

            // 현재 weight 기록
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        return answer;
    }
}