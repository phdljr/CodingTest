import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0;i<arr.length;){
            if(answer.isEmpty()){
                answer.add(arr[i++]);
            }
            
            if(answer.get(answer.size() - 1) < arr[i]){
                answer.add(arr[i++]);
            } else{
                answer.remove(answer.size() - 1);
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}