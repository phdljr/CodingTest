package beakjoon.pm14501;

import java.util.Scanner;

public class Main {

    static int n, max = 0;
    static int[] t;
    static int[] p;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        t = new int[n+1];
        p = new int[n+1];

        for(int i=1;i<=n;i++){
            String[] temp = sc.nextLine().split(" ");
            t[i] = Integer.parseInt(temp[0]);
            p[i] = Integer.parseInt(temp[1]);
        }
        go(1, 0);
        System.out.println(max);
    }

    private static void go(int day, int sum){
        // 더 이상 일할 시간이 없을 경우
        if(day == n+1){
            if(sum > max)
                max = sum;
            return;
        }

        if(day > n+1)
            return;

        // 그날 일을 하는 경우
        go(day+t[day], sum+p[day]);
        // 안하는 경우
        go(day+1, sum);
    }
}
