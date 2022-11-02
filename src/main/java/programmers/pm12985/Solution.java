package programmers.pm12985;

class Solution {
    public static void main(String[] args) {
        new Solution().solution(8, 4, 7);
    }

    public int solution(int n, int a, int b) {
        int round = 1;

        // a가 더 작도록 설정
        int temp = a;
        a = Math.min(a, b);
        b = Math.max(temp, b);

        while(true){
            if(isFight(a,b)){
                break;
            }
            a = setNumber(a);
            b = setNumber(b);
            round++;
        }
        return round;
    }

    private int setNumber(int n) {
        if(n%2==1)
            n++;
        n = n/2;
        return n;
    }

    private boolean isFight(int a, int b) {
        if(a % 2 != 1) // a가 홀수가 아니라면
            return false;
        if(Math.abs(a-b) != 1) // 서로 1차이가 안난다면
            return false;
        return true;
    }
}