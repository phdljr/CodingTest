package programmers.pm12980;

public class SolutionBackup {
    public static void main(String[] args) {
        System.out.println(new SolutionBackup().solution(5));
    }

    static int min = Integer.MAX_VALUE;
    public int solution(int n) {
        go(0,n, 0);
        return min;
    }

    // k: 이동한 거리
    // n: 목표 거리
    // m: 점프한 거리
    public static void go(int k, int n, int m){
        if(min < m) return; // 최소값보다 더 이동할 경우
        if(k>n) return; // 목표치 이상으로 이동할 경우
        if(k == n) {
            if(min > m)
                min = m;
            return;
        }
        go(k+1, n, m+1);
        if(k==0) return;
        go(k*2,n, m);
    }
}