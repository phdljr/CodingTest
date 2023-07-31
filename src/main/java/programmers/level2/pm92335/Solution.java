package programmers.level2.pm92335;

public class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] strList = Integer.toString(n, k).split("0");

        for(String str: strList){
            if(str.equals("") || str.equals("0"))
                continue;

            if(isPrime(Long.parseLong(str))){
                answer++;
            }
        }

        return answer;
    }

    public boolean isPrime(long num){
        if(num == 1 || num == 0){
            return false;
        }

        for(long i=2;i*i<=num;i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }
}