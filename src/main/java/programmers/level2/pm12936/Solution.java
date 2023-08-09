package programmers.level2.pm12936;

import java.util.*;

public class Solution {

    public int[] solution(int n, long k) {
        long[] dp = new long[n+1];
        int[] answer = new int[n];

        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]*i;
        }

        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(i+1);
        }
        List<Integer> res = new ArrayList<>();

        while(true){
            long num = dp[n-1];
            if(k % num == 0){ // 맨 앞의 숫자가 정해진 상태에서 마지막 순서인 경우
                res.add(list.remove((int)(k/num) - 1));
                break;
            } else{
                res.add(list.remove((int)(k/num)));
                k%=num;
            }
            n--;
        }

        if(!list.isEmpty()){
            for(int i=list.size()-1;i>=0;i--){
                res.add(list.get(i));
            }
        }

        for(int i=0;i<res.size();i++){
            answer[i] = res.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        new Solution().solution(3, 5);
    }
}