package beakjoon.pm11722;

import java.util.Scanner;

public class Main {
    static long[] d = new long[1001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] a = new int[n+1];
        String[] s = sc.nextLine().split(" ");
        for(int i=1;i<=n;i++){
            a[i] = Integer.parseInt(s[i-1]);
            d[i] = 1;
        }

        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++){
                if(a[j] > a[i] && d[i] < d[j] + 1){
                    d[i] = d[j] + 1;
                }
            }
        }

        long max = 0;
        for(int i=1;i<=n;i++){
            if(max < d[i]){
                max = d[i];
            }
        }
        System.out.println(max);
    }
}
