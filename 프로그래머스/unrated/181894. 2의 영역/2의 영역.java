import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        
        for(int n: arr){
            list.add(n);
        }
        
        int start = list.indexOf(2);
        int end = list.lastIndexOf(2);
        
        if(start == -1){
            return new int[]{-1};
        } else if(start == end){
            return new int[]{2};
        } else{
            return list.subList(start, end+1).stream().mapToInt(n->n).toArray();
        }
    }
}