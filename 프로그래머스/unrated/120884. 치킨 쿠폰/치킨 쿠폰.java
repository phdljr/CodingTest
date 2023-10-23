class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int coupon = 0;
        for(int i=0;i<chicken;i++){
            coupon++;
            if(coupon == 10){
                answer++;
                coupon = 1;
            }
        }
        return answer;
    }
}