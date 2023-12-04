import java.time.*;
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        LocalDate todayDate = LocalDate.parse(today.replaceAll("\\.", "-"));
        
        HashMap<String, Integer> termsMap = new HashMap<>();
        for(int i=0;i<terms.length;i++){
            String[] str = terms[i].split(" ");
            termsMap.put(str[0], Integer.parseInt(str[1]));
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<privacies.length;i++){
            LocalDate date = LocalDate.parse(privacies[i].substring(0, 10).replaceAll("\\.", "-"));
            String term = privacies[i].substring(11, 12);

            LocalDate addMonthDate = date.plusMonths(termsMap.get(term));
            if(addMonthDate.isBefore(todayDate) || addMonthDate.isEqual(todayDate)){
                list.add(i+1);
            }
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
}