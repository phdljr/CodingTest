package programmers.pm12911;

class Solution {
    public int solution(int n) {
        int count = Integer.bitCount(n);

        while(true){
            n++;
            if(count == Integer.bitCount(n))
                break;
        }

        return n;
    }
}