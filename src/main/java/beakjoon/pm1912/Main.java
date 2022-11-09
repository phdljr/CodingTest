package beakjoon.pm1912;

import java.util.Scanner;

public class Main {

    static int[] d = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] str = sc.nextLine().split(" ");
        int[] a = new int[n+1];
        for(int i=1;i<=n;i++){
            a[i] = Integer.parseInt(str[i-1]);
        }

        for(int i=1;i<=n;i++){
            d[i] = a[i];
            if(i==1) continue;
            if(d[i-1] + a[i] > d[i]){
                d[i] = d[i-1] + a[i];
            }
        }

        int answer = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(answer < d[i])
                answer = d[i];
        }
        System.out.println(answer);
    }
}
