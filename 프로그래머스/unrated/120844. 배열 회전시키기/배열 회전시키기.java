import java.util.*;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        List<Integer> list = new ArrayList<>();
        for(int n: numbers){
            list.add(n);
        }
        
        if(direction.equals("left")){
            list.add(list.remove(0));
        } else {
            list.add(0, list.remove(list.size()-1));
        }
        return list.stream().mapToInt(num->num).toArray();
    }
}