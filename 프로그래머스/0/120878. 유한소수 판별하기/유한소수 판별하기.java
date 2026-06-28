class Solution {
    public int solution(int a, int b) {
        
        if(a >= b)
            b /= gcd(a, b);
        else
            b /= gcd(b, a);
        
        while(true){
            if(b%2==0){
                b/=2;
                continue;
            }
            if(b%5==0){
                b/=5;
                continue;
            }
            
            break;
        }
        
        return b == 1 ? 1 : 2;
    }
    
    int gcd(int a, int b) {
        if(b == 0) 
            return a;
        else 
            return gcd(b, a % b);
    }
}