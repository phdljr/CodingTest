import java.math.*;

class Solution {
    public int solution(int balls, int share) {
        BigInteger answer = fact(balls).divide(fact(balls - share).multiply(fact(share)));
        return answer.intValue();
    }
    
    public BigInteger fact(int n){
        BigInteger result = new BigInteger("1");
        for(int i=1;i<=n;i++){
            result = result.multiply(new BigInteger(""+i));
        }
        return result;
    }
}