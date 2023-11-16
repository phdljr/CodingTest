class Solution {
    public int solution(int a, int b, int n) {
        // a: 빈 병의 필요 개수
        // b: 그에 따른 제공되는 콜라
        // n: 현재 갖고있는 빈 병의 개수
        int answer = 0;
            
        while(!(n<a)){
            answer += n/a*b;
            n = (n/a)*b + n % a;
        }
        
        return answer;
    }
}