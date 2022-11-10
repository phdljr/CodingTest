package beakjoon.pm13398;

import java.util.Scanner;

public class Main {
    static long[] d1 = new long[100001];
    static long[] d2 = new long[100001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] a = new int[n+1];
        String[] s = sc.nextLine().split(" ");
        for(int i=1;i<=n;i++){
            a[i] = Integer.parseInt(s[i-1]);
        }

        for(int i=1;i<=n;i++){
            d1[i] = a[i];
            if(d1[i-1] + a[i] > a[i]){
                d1[i] = d1[i-1] + a[i];
            }
        }

        for(int i=n;i>=1;i--){
            d2[i] = a[i];
            if(i == n){
                continue;
            }
            if(d2[i+1] + a[i] > a[i]){
                d2[i] = d2[i+1] + a[i];
            }
        }

        long answer = d1[1];
        for(int i=2;i<=n;i++){
            if(answer < d1[i])
                answer = d1[i];
        }
        for(int i=2;i<n;i++){
            if(answer < d1[i-1] + d2[i+1])
                answer = d1[i-1] + d2[i+1];
        }
        System.out.println(answer);
    }
}