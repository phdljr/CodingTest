package programmers.pm12924;

class Solution {
    public static void main(String[] args) {

    }
    public int solution(int n) {
        int answer = 0;

        int sum;
        for(int i=n;i>0;i--){
            sum = 0;
            for(int j=i;j>0;j--){
                sum+=j;
                if(sum > n)
                    break;
                if(sum == n){
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}
