import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        List<String> list = new ArrayList<>();
        for(String str: my_string.split(" ")){
            if(str.equals("")) continue;
            list.add(str);
        }
        return list.toArray(String[]::new);
    }
}