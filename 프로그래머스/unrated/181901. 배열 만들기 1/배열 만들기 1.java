import java.util.*;

class Solution {
    public int[] solution(int n, int k) {
        List<Integer> list = new ArrayList<Integer>();
        int i = 1;
        while(i*k <= n){
            list.add(i*k);
            i++;
        }
        return list.stream().mapToInt(ni->ni).toArray();
    }
}