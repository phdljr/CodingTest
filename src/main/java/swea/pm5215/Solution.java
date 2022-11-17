package swea.pm5215;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {

    static int n = 0;
    static int l = 0;
    static int max = 0;
    static int[] sa;
    static int[] ka;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            String[] s = br.readLine().split(" ");
            n = Integer.parseInt(s[0]); // 재료 수
            l = Integer.parseInt(s[1]); // 제한 칼로리
            sa = new int[n+1]; // 점수 배열
            ka = new int[n+1]; // 칼로리 배열
            for(int i=1;i<=n;i++) {
                String[] s2 = br.readLine().split(" ");
                sa[i] = Integer.parseInt(s2[0]);
                ka[i] = Integer.parseInt(s2[1]);
            }

            go(0,0,1);

            System.out.printf("#%d %d\n", test_case, max);
        }
    }

    private static void go(int curs, int curk, int index){
        if(curk > l){
            return;
        }
        if(index >= n) {
            if (max < curs) {
                max = curs;
            }
            return;
        }
        go(curs + sa[index], curk + ka[index], index+1);
        go(curs, curk, index+1);
    }
}