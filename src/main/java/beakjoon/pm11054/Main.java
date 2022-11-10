package beakjoon.pm11054;

import java.util.Scanner;

public class Main {
    static long[] d1 = new long[1001];
    static long[] d2 = new long[1001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] a = new int[n+1];
        String[] s = sc.nextLine().split(" ");
        for(int i=1;i<=n;i++){
            a[i] = Integer.parseInt(s[i-1]);
            d1[i] = 1;
            d2[i] = 1;
        }

        // 감소
        for(int i=n;i>=1;i--){
            for(int j=i+1;j<=n;j++){
                if(a[j] < a[i] && d1[i] < d1[j] + 1){
                    d1[i] = d1[j] + 1;
                }
            }
        }

        // 증가
        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++){
                if(a[j] < a[i] && d2[i] < d2[j] + 1){
                    d2[i] = d2[j] + 1;
                }
            }
        }

        long max = 0;
        for(int i=1;i<=n;i++){
            if(max < d1[i] + d2[i] - 1){
                max = d1[i] + d2[i] - 1;
            }
        }
        System.out.println(max);
    }
}
