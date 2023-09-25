import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        List<Integer> list = new ArrayList<>();
        for(String s: my_string.replaceAll("[^\\d]","").split("")){
            list.add(Integer.parseInt(s));
        }
        Collections.sort(list);
        return list.stream().mapToInt(n->n).toArray();
    }
}