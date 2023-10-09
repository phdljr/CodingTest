import java.util.*;

class Solution {
    public String[] solution(String myString) {
        List<String> list = new ArrayList<>();
        for(String str: myString.split("x")){
            if(str.equals(""))
                continue;
            list.add(str);
        }
        Collections.sort(list);
        return list.toArray(String[]::new);
    }
}