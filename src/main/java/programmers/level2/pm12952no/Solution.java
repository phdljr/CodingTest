package programmers.level2.pm12952no;

public class Solution {

    static int answer = 0;
    static int[] vx = new int[12]; // 인덱스: 퀸의 행, 값: 퀸의 열

    public int solution(int n){
        go(0, n);
        return answer;
    }

    public void go(int depth, int n){
        if(depth == n){
            answer++;
            return;
        }
        for(int i=0;i<n;i++){
            vx[depth] = i;

            for(int j=0;j<depth;j++){
                if(vx[i] == vx[j]) return;
                if(Math.abs(i - j) == Math.abs(vx[i] - vx[j])) return;
            }

            go(depth+1, n);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(4));
    }
}
