class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        int second = 0;
        for(int i=0;i<prices.length;i++){
            for(int j=i;j<prices.length-1;j++){
                if(prices[i] > prices[j])
                    break;
                second++;
            }
            answer[i] = second;
            second = 0;
        }
        
        return answer;
    }
}