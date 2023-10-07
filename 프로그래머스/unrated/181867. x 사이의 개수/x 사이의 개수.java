import java.util.*;

class Solution {
    public int[] solution(String myString) {
        myString += " ";
        List<Integer> list = new ArrayList<>();
        for(String s: myString.split("x")){
            s = s.replace(" ", "");
            list.add(s.length());
        }
        return list.stream().mapToInt(n->n).toArray();
    }
}