package beakjoon.pm9095;

import java.util.Scanner;

public class AnotherMain {
    static int result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(go(0,0,n));
    }

    private static int go(int count, int sum, int n) {
        if(sum == n) return 1;
        if(sum > n) return 0;
        int now = 0;
        for(int i=1;i<=3;i++){
            now += go(count+1, sum+i, n);
        }
        return now;
    }
}
