package programmers.level1.pm150370;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        LocalDate todayDate = LocalDate.parse(today.replaceAll("\\.", "-"));

        HashMap<String, Integer> termsMap = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] str = terms[i].split(" ");
            termsMap.put(str[0], Integer.parseInt(str[1]));
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            LocalDate date = LocalDate.parse(privacies[i].substring(0, 10).replaceAll("\\.", "-"));
            String term = privacies[i].substring(11, 12);

            LocalDate addMonthDate = date.plusMonths(termsMap.get(term));
            if (addMonthDate.isBefore(todayDate) || addMonthDate.isEqual(todayDate)) {
                list.add(i + 1);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
        System.out.println(new Solution().solution(today, terms, privacies));
    }
}
