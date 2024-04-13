import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        List<Integer> list = new ArrayList<>();
        for(int num: numlist){
            list.add(num);
        }
        
        Collections.sort(list, (a, b) -> {
                if(Math.abs(a-n)!=Math.abs(b-n)){
                    return Math.abs(a-n)-Math.abs(b-n);
                }
                else{
                    return b-a;
                }
            }
        );
        
        return list.stream().mapToInt(i->i).toArray();
    }
}