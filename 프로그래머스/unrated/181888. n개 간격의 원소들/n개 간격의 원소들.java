import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> list = new ArrayList();
        int i = 0;
        while(num_list.length > i){
            list.add(num_list[i]);
            i+=n;
        }
        return list.stream().mapToInt(num->num).toArray();
    }
}