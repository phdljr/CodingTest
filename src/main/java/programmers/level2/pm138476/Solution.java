package programmers.level2.pm138476;

import java.util.*;

public class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < tangerine.length; i++) {
            if (map.containsKey(tangerine[i])) {
                map.put(tangerine[i], map.get(tangerine[i]) + 1);
            } else {
                map.put(tangerine[i], 1);
            }
        }

        List<Map.Entry<Integer, Integer>> list =  new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for(Map.Entry<Integer, Integer> entry: list){
            k -= entry.getValue();
            answer++;
            if(k <= 0){
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 3, 4, 5,3,3,3};
        System.out.println(new Solution().solution(6, a));
    }
}
