class Solution {
    public int solution(int n) {
        int i = 1;
        while(fact(i)<=n){
            i++;
        }
        
        return i-1;
    }
    
    public int fact(int num){
        int result = 1;
        for(int i=1;i<=num;i++){
            result *= i;
        }
        return result;
    }
}