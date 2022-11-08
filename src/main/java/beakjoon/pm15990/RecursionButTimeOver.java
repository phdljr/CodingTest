package beakjoon.pm15990;

import java.util.Scanner;

public class RecursionButTimeOver {
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for(int i=0;i<t;i++){
            answer = 0;
            int n = Integer.parseInt(sc.nextLine());

            go(n, 0, -2, -1);
            System.out.println(answer);
        }
    }

    private static void go(int n, int sum, int prev, int next){
        if(prev == next || sum > n){
            return;
        }
        if(sum == n){
            answer++;
        }
        go(n, sum+3, next, 3);
        go(n, sum+2, next, 2);
        go(n, sum+1, next, 1);
    }
}
