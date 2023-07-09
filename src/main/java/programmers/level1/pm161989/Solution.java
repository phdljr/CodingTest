package programmers.level1.pm161989;

public class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] check = new boolean[n];

        for(int i=0;i<section.length;i++){
            check[section[i]-1] = true;
        }

        for(int i=0;i<check.length;i++){
            if(check[i] == true){
                for(int j=i;j<i+m && j < check.length;j++){
                    check[j] = false;
                }
                answer++;
            }
        }

        return answer;
    }
}
