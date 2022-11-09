package beakjoon.pm14501;

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic {

    static int n=0;
    static int[] t;
    static int[] p;
    static int[] d = new int[16];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        t = new int[n+1];
        p = new int[n+1];
        Arrays.fill(d, -1);

        for(int i=1;i<=n;i++){
            String[] temp = sc.nextLine().split(" ");
            t[i] = Integer.parseInt(temp[0]);
            p[i] = Integer.parseInt(temp[1]);
        }
        int answer = go(1);
        System.out.println(answer);
    }

    private static int go(int day){
        // 더 이상 일할 시간이 없을 경우
        if(day == n+1){
            return 0;
        }
        if(day > n+1) {
            return Integer.MIN_VALUE;
        }
        if(d[day] != -1){
            return d[day];
        }

        // 그날 일을 하는 경우
        int t1 = p[day] + go(day+t[day]);
        // 안하는 경우
        int t2 = go(day+1);
        d[day] = Math.max(t1, t2);
        return d[day];
    }
}
