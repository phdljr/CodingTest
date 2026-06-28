import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int start = 0;
        for(int i=people.length-1;i>=start;i--){
            if(people[start] + people[i] <= limit) {
                if(i == start){
                    answer++;
                    break;
                }
                start++;
            }
            answer++;
        }
        return answer;
    }
}