package programmers.level1.pm92334;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        HashMap<String, HashSet<String>> map = new HashMap<>();
        boolean[] block = new boolean[id_list.length];
        HashMap<String, Integer> email = new HashMap<>();

        for(String id: id_list){
            map.put(id, new HashSet<String>());
            email.put(id, 0);
        }

        for(int i=0;i<report.length;i++){
            String[] str = report[i].split(" ");
            map.get(str[1]).add(str[0]);
        }

        for(int i=0;i<id_list.length;i++){
            if(map.get(id_list[i]).size() >= k){
                block[i] = true;
            }
            if(block[i]){
                for(String reportId: map.get(id_list[i])){
                    email.put(reportId, email.get(reportId)+1);
                }
            }
        }

        for(int i=0;i<email.size();i++){
            answer[i] = email.get(id_list[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        System.out.println(new Solution().solution(id_list, report, k));
    }
}