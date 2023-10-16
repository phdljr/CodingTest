import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(String str: strArr){
            map.put(str.length(), map.getOrDefault(str.length(), 0) + 1);
            if(map.get(str.length()) > max){
                max = map.get(str.length());
            }
        }
        return max;
    }
}