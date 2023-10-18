import java.math.BigInteger;

class Solution {
    public String solution(String a, String b) {
        String answer = new BigInteger(a).add(new BigInteger(b)).toString();
        return answer;
    }
}